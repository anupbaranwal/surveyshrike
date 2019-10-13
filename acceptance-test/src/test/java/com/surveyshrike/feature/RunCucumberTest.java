package com.surveyshrike.feature;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber.json"}, features = { "classpath:features/survey.feature" },
    glue = {"com.surveyshrike"}
    )
public class RunCucumberTest {
}
