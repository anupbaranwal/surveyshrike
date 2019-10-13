package com.surveyshrike.feature;

import com.surveyshrike.SurveyE2EApplicationTest;
import com.surveyshrike.domain.model.QuestionAnswer;
import com.surveyshrike.domain.model.Survey;
import com.surveyshrike.domain.port.SurveyReader;
import com.surveyshrike.domain.port.SurveyRepository;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SurveyE2EApplicationTest.class)
@ContextConfiguration(classes = SurveyE2EApplicationTest.class, loader = SpringBootContextLoader.class)
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
public class SurveyStepdefs {

  @Autowired
  private SurveyRepository surveyRepository;

  @Autowired
  private SurveyReader surveyReader;

  private Survey survey = new Survey();
  private Long surveyId;

  @Given("^A list of survey creators$")
  public void a_list_of_survey_creators(DataTable table) throws Throwable {
    List<Map<String, String>> list = table.asMaps(String.class, String.class);
    survey.setCreatorName(list.get(0).get("name"));
  }

  @Given("^A list of survey associated with the creator$")
  public void a_list_of_survey(DataTable table) throws Throwable {
    List<Map<String, String>> list = table.asMaps(String.class, String.class);
    survey.setName(list.get(0).get("name"));
    survey.setDescription(list.get(0).get("description"));
  }

  @Given("^A list of question and answers associated with the survey$")
  public void a_list_of_question_and_answers(DataTable table) throws Throwable {
    List<Map<String, String>> list = table.asMaps(String.class, String.class);
    QuestionAnswer questionAnswer1 = new QuestionAnswer();
    QuestionAnswer questionAnswer2 = new QuestionAnswer();
    questionAnswer1.setQuestion(list.get(0).get("question"));
    questionAnswer1.setType(list.get(0).get("type"));
    questionAnswer1.setQuestionOptions(list.get(0).get("options"));
    questionAnswer1.setAnswers(list.get(0).get("answers"));
    questionAnswer2.setQuestion(list.get(1).get("question"));
    questionAnswer2.setType(list.get(1).get("type"));
    questionAnswer2.setQuestionOptions(list.get(1).get("options"));
    questionAnswer2.setAnswers(list.get(1).get("answers"));
    List<QuestionAnswer> questionAnswers = new ArrayList<>();
    questionAnswers.add(questionAnswer1);
    questionAnswers.add(questionAnswer2);
    survey.setQuestionAnswer(questionAnswers);
    surveyId = surveyRepository.saveSurvey(survey);
  }

  @When("^user asks for a survey with survey id$")
  public void user_asks_for_a_survey_with_survey_id() throws Throwable {
    survey = surveyReader.getSurvey(surveyId);
  }

  @Then("^user should be given the survey$")
  public void user_should_be_given_the_survey(DataTable table) throws Throwable {
    List<Map<String, String>> list = table.asMaps(String.class, String.class);

    Assertions.assertThat(list.get(0).get("name")).isEqualTo(survey.getName());
    Assertions.assertThat(list.get(0).get("description")).isEqualTo(survey.getDescription());
    Assertions.assertThat(list.get(0).get("creatorName")).isEqualTo(survey.getCreatorName());
  }
}
