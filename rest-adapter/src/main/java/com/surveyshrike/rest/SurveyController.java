package com.surveyshrike.rest;

import com.surveyshrike.domain.model.Survey;
import com.surveyshrike.domain.port.SurveyReader;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {

  @Autowired
  SurveyReader surveyReader;

  @GetMapping
  @ApiOperation(value = "Fetches the survey based on survey id")
  public Survey surveys(
      @ApiParam(value = "The survey identifier", example = "9289109") @RequestParam Long surveyId) {
    return surveyReader.getSurvey(surveyId);
  }
}
