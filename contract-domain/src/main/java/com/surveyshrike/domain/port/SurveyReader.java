package com.surveyshrike.domain.port;

import com.surveyshrike.domain.model.Survey;
import java.util.List;

public interface SurveyReader {
  default List<Survey> getSurveys(String userId){
    return null;
  };
  Survey getSurvey(Long surveyId);
}
