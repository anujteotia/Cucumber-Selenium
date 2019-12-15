package utils;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import configurations.TestEnums;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Hooks class contains operation to be performed before and after the execution
 * of scenario.
 * 
 * @author anujteotia
 * @variable: filename - loading the location of properties file from enum file.
 * @variable: driver - selenium webdriver
 * @variable: logger - log4j2 logger instance
 *
 */
public class Hooks {
	private static final String filename = TestEnums.PROPFILE.getValue();
	public static PropUtilities values = new PropUtilities(filename);
	public static WebDriver driver = WebDriverInitialization.getDriver(values.getValueUsingKey("driver"));
	public final static Logger logger = LogManager.getLogger(Hooks.class);

	/**
	 * This function logs the name of the scenario name before starting the actual
	 * execution of the scenario
	 * 
	 * @param scenario Scenario object
	 */
	@Before(order = 0)
	public void before(Scenario scenario) {
		CreateFolder.makeFolder("screenshots");
		logger.info("------------------------------");
		logger.info("Starting - " + scenario.getName());
		logger.info("------------------------------");
	}

	/**
	 * This function logs the name and status of the scenario executed at the end of
	 * execution.
	 * 
	 * @param scenario Scenario object
	 */
	@After(order = 1)
	public void after(Scenario scenario) {
		logger.info("------------------------------");
		logger.info(scenario.getName() + " Status - " + scenario.getStatus());
		logger.info("------------------------------");
	}

	/**
	 * This method takes screenshot in case of scenario failure and quits the
	 * webdriver at the end of execution.
	 * 
	 * @param scenario Scenario object
	 * @throws Throwable
	 */
	@After(order = 0)
	public void screenShot(Scenario scenario) throws Throwable {
		try {
			if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/screenshots/"
						+ screenshotName + ".png");
				Files.copy(screenshot, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			}
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			logger.error(somePlatformsDontSupportScreenshots.getMessage());
		} finally {
			WebDriverInitialization.destroyDriver();
		}
	}

}