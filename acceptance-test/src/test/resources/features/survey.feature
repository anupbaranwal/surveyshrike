#
# Feature: Survey
#
@surveyshrike
Feature: Survey
  As a user I want to create the survey and also would like to take part in any existing surveys

  Scenario: Get the survey based on given survey id
    Given A list of survey creators
      | name |
      | anup |
    And A list of survey associated with the creator
      | surveyId |   name   |     description      |
      |   123    | Survey 1 | Survey 1 description |
    And A list of question and answers associated with the survey
      | questionId |  question  | type | answers |     options     |
      |     1      | question 1 |  M   |         | Choice1;choice2 |
      |     2      | question 2 |  T   |         |                 |
    When user asks for a survey with survey id
    Then user should be given the survey
      |   name   |     description      | creatorName |
      | Survey 1 | Survey 1 description |    anup     |
