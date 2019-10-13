package com.surveyshrike;

import com.surveyshrike.domain.SurveyReaderService;
import com.surveyshrike.domain.port.SurveyReader;
import com.surveyshrike.domain.port.SurveyRepository;
import com.surveyshrike.jpa.InMemorySurveyRepository;
import com.surveyshrike.jpa.dao.SurveyDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SurveyE2EApplicationTest {
  public static void main(String[] args) {
    SpringApplication.run(SurveyE2EApplicationTest.class, args);
  }

  @Bean
  public SurveyRepository getSurveyRepository(SurveyDao surveyDao) {
    return new InMemorySurveyRepository(surveyDao);
  }

  @Bean
  public SurveyReader getSurveyReader(SurveyRepository surveyRepository) {
    return new SurveyReaderService(surveyRepository);
  }
}
