package com.isaccof;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/getUserById.feature", plugin = {"pretty", "html:target/cucumber"}, glue = {"com.isaccof.stepdefs"})
public class CucumberTest {
}
