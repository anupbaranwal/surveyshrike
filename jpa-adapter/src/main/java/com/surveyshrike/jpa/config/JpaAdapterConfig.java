package com.surveyshrike.jpa.config;

import com.surveyshrike.domain.port.SurveyRepository;
import com.surveyshrike.jpa.dao.SurveyDao;
import com.surveyshrike.jpa.InMemorySurveyRepository;
import org.springframework.context.annotation.Bean;

public class JpaAdapterConfig {

    @Bean
    public SurveyRepository getSurveyRepository(SurveyDao surveyDao) {
        return new InMemorySurveyRepository(surveyDao);
    }
}
