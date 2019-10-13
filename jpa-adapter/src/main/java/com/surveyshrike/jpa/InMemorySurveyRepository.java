package com.surveyshrike.jpa;

import com.surveyshrike.domain.model.QuestionAnswer;
import com.surveyshrike.domain.model.Survey;
import com.surveyshrike.domain.port.SurveyRepository;
import com.surveyshrike.jpa.dao.SurveyDao;
import com.surveyshrike.jpa.entity.CreatorEntity;
import com.surveyshrike.jpa.entity.QuestionAnswerEntity;
import com.surveyshrike.jpa.entity.SurveyEntity;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;

public class InMemorySurveyRepository implements SurveyRepository {

  private SurveyDao surveyDao;

  public InMemorySurveyRepository(SurveyDao surveyDao) {
    this.surveyDao = surveyDao;
  }

  @Override
  public Survey getSurvey(Long surveyId) {
    SurveyEntity survey = surveyDao.findById(surveyId).orElse(null);
    return serializeSurvey(survey);
  }

  @Override
  public Long saveSurvey(Survey survey) {
    SurveyEntity surveyEntity = deSerializeSurvey(survey);
    surveyEntity = surveyDao.save(surveyEntity);
    return surveyEntity.getId();
  }

  @Override
  public List<Survey> getSurveys(String userId) {
    return null;
  }

  private SurveyEntity deSerializeSurvey(Survey survey) {
    List<QuestionAnswerEntity> questionAnswerEntities = survey.getQuestionAnswer().stream()
        .map(this::deSerializeToQuestionAnswer)
        .collect(Collectors.toList());
    CreatorEntity creatorEntity = new CreatorEntity();
    creatorEntity.setId(survey.getCreatorId());
    creatorEntity.setName(survey.getCreatorName());
    SurveyEntity surveyEntity = new SurveyEntity();
    surveyEntity.setCreator(creatorEntity);
    surveyEntity.setDescription(survey.getDescription());
    surveyEntity.setId(survey.getId());
    surveyEntity.setName(survey.getName());
    surveyEntity.setQuestionAnswers(questionAnswerEntities);
    return surveyEntity;
  }


  private Survey serializeSurvey(SurveyEntity surveyEntity) {
    if(Objects.isNull(surveyEntity)) {
      return null;
    }
    List<QuestionAnswer> questionAnswers
        = surveyEntity.getQuestionAnswers().stream().map(this::serializeToQuestionAnswer)
        .collect(Collectors.toList());
    return Survey.builder().id(surveyEntity.getId()).name(surveyEntity.getName())
        .description(surveyEntity.getDescription())
        .questionAnswer(questionAnswers)
        .creatorId(surveyEntity.getCreator().getId())
        .creatorName(surveyEntity.getCreator().getName())
        .build();
  }

  private QuestionAnswer serializeToQuestionAnswer(QuestionAnswerEntity questionAnswerEntity) {
    QuestionAnswer questionAnswer = new QuestionAnswer();
    BeanUtils.copyProperties(questionAnswerEntity, questionAnswer);
    return questionAnswer;
  }

  private QuestionAnswerEntity deSerializeToQuestionAnswer(QuestionAnswer questionAnswer) {
    QuestionAnswerEntity questionAnswerEntity = new QuestionAnswerEntity();
    BeanUtils.copyProperties(questionAnswer, questionAnswerEntity);
    return questionAnswerEntity;
  }
}
