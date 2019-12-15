package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	private static ChromeOptions chromeOptions = null;
	private static FirefoxOptions firefoxOptions = null;
	public final static Logger logger = LogManager.getLogger(PropUtilities.class);
	public static final String USERNAME = "USERNAME";
	public static final String ACCESS_KEY = "ACCESS_KEY";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

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
					chromeOptions = new ChromeOptions();
					chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					chromeOptions.setExperimentalOption("prefs", prefs);
					driver = new ChromeDriver(chromeOptions);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			} else if (browserName != null && TestEnums.FIREFOX.getValue().equalsIgnoreCase(browserName)) {
				if (driver == null) {
					firefoxOptions = new FirefoxOptions();
					driver = new FirefoxDriver(firefoxOptions);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}

			} else if (browserName != null && TestEnums.SAUCELAB_CHROME.getValue().equalsIgnoreCase(browserName)) {
				if (driver == null) {
					chromeOptions = new ChromeOptions();
					chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
					chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("load-extension"));
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					chromeOptions.setExperimentalOption("prefs", prefs);
					driver = new RemoteWebDriver(new java.net.URL(URL), chromeOptions);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			} else if (browserName != null && TestEnums.SAUCELAB_FIREFOX.getValue().equalsIgnoreCase(browserName)) {
				if (driver == null) {
					firefoxOptions = new FirefoxOptions();
					driver = new RemoteWebDriver(new java.net.URL(URL), firefoxOptions);
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
			}

			return driver;
		} catch (Exception e) {
			logger.info(e.getStackTrace());
		}
		return driver;

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
