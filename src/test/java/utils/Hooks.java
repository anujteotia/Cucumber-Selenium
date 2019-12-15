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

public class Hooks {

	private static final String filename = TestEnums.PROPFILE.getValue();
	public static PropUtilities values = new PropUtilities(filename);
	public static WebDriver driver = WebDriverInitialization.getDriver(values.getValueUsingKey("driver"));
	public final static Logger logger = LogManager.getLogger(Hooks.class);

	@Before(order = 0)
	public void before(Scenario scenario) {
		logger.info("------------------------------");
		logger.info("Starting - " + scenario.getName());
		logger.info("------------------------------");
	}

	@After(order = 1)
	public void after(Scenario scenario) {
		logger.info("------------------------------");
		logger.info(scenario.getName() + " Status - " + scenario.getStatus());
		logger.info("------------------------------");
	}

	@After(order = 0)
	public void screenShot(Scenario scenario) throws Throwable {
		try {
			if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
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