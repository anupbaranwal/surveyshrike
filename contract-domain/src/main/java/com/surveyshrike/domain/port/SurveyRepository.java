package com.surveyshrike.domain.port;

import com.surveyshrike.domain.model.Survey;
import java.util.List;

public interface SurveyRepository {
  List<Survey> getSurveys(String userId);
  Survey getSurvey(Long surveyId);
}
