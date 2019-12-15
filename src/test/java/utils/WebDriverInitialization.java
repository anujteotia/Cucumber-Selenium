package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import configurations.TestEnums;

/**
 * 
 * This class initialises the selenium webdriver.
 * 
 * @author anujteotia
 *
 */

public class WebDriverInitialization {
	private static WebDriver driver = null;
	private static ChromeOptions options = null;
	private static DesiredCapabilities dc = null;
	public final static Logger logger = LogManager.getLogger(PropUtilities.class);

	/**
	 * default constructor
	 */
	private WebDriverInitialization() {
	}

	/**
	 * This function initiates web driver according to the browser name provided.
	 * 
	 * @param browserName name of the web browser to be opened.
	 * @return web driver.
	 */
	private static WebDriver initiateDriver(String browserName) {
		try {
			if (browserName != null && TestEnums.CHROME.getValue().equalsIgnoreCase(browserName)) {
				if (driver == null) {
					options = new ChromeOptions();
					options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					options.setExperimentalOption("prefs", prefs);
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			} else if (browserName != null && TestEnums.FIREFOX.getValue().equalsIgnoreCase(browserName)) {
				if (driver == null) {
					dc = DesiredCapabilities.firefox();
					dc.setCapability("marionette", true);
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

			}

			return driver;
		} catch (Exception e) {
			logger.info(e.getStackTrace());
			throw e;
		}

	}

	/**
	 * 
	 * @param browserName name of the browser to be returned or initiated.
	 * @return web driver
	 */
	public static WebDriver getDriver(String browserName) {
		if (driver != null) {
			return driver;
		}
		return initiateDriver(browserName);
	}

	/**
	 * This function quits the web driver.
	 */
	public static void destroyDriver() {
		driver.quit();
		driver = null;
	}
}
