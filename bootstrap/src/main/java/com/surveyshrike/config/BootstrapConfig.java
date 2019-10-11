package com.surveyshrike.config;

import com.surveyshrike.domain.SurveyReaderService;
import com.surveyshrike.domain.port.SurveyReader;
import com.surveyshrike.domain.port.SurveyRepository;
import com.surveyshrike.jpa.config.JpaAdapterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaAdapterConfig.class)
public class BootstrapConfig {
  @Bean
  public SurveyReader getSurveyReader(SurveyRepository surveyRepository) {
    return new SurveyReaderService(surveyRepository);
  }
}
