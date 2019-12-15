package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utils.Hooks;

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
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
        Reporter.setSystemInfo("browser", Hooks.values.getValueUsingKey("driver"));
    }
}
