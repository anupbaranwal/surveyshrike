package com.surveyshrike.jpa;

import com.surveyshrike.domain.model.QuestionAnswer;
import com.surveyshrike.domain.model.Survey;
import com.surveyshrike.domain.port.SurveyRepository;
import com.surveyshrike.jpa.dao.SurveyDao;
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
    return constructSurvey(survey);
  }

  @Override
  public List<Survey> getSurveys(String userId) {
    return null;
  }

  private Survey constructSurvey(SurveyEntity surveyEntity) {
    if(Objects.isNull(surveyEntity)) {
      return null;
    }
    List<QuestionAnswer> questionAnswers
        = surveyEntity.getQuestionAnswers().stream().map(this::convertToQuestionAnswer)
        .collect(Collectors.toList());
    return Survey.builder().id(surveyEntity.getId()).name(surveyEntity.getName())
        .description(surveyEntity.getDescription())
        .questionAnswer(questionAnswers)
        .creatorId(surveyEntity.getCreator().getId())
        .creatorName(surveyEntity.getCreator().getName())
        .build();
  }

  private QuestionAnswer convertToQuestionAnswer(QuestionAnswerEntity questionAnswerEntity) {
    QuestionAnswer questionAnswer = new QuestionAnswer();
    BeanUtils.copyProperties(questionAnswerEntity, questionAnswer);
    return questionAnswer;
  }
}
