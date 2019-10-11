package com.surveyshrike.domain;

import com.surveyshrike.domain.model.Survey;
import com.surveyshrike.domain.port.SurveyReader;
import com.surveyshrike.domain.port.SurveyRepository;

public class SurveyReaderService implements SurveyReader {

  private SurveyRepository surveyRepository;

  public SurveyReaderService(SurveyRepository surveyRepository) {
    this.surveyRepository = surveyRepository;
  }

  @Override
  public Survey getSurvey(Long surveyId) {
    return this.surveyRepository.getSurvey(surveyId);
  }
}
