package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This is cucumber runner class which executes the Selenium code which is
 * linked with feature class and generates extent and junit reports.
 * 
 * @author anujteotia
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = { "seleniumgluecode", "utils" }, plugin = { "pretty",
		"html:target/junit-reports",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extentReport.html" }, monochrome = true)

public class TestRunner {

}
