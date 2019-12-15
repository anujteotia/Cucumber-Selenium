package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = { "seleniumgluecode", "utils"}, plugin = {"pretty", "html:target/junit-reports",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentReport.html" }, monochrome = true)

public class TestRunner {

}
