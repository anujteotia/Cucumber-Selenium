package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Hooks;

/**
 * This class contains the functions which implements the login and search
 * functionality on animana web ui.
 * 
 * @author anujteotia
 *
 */

public class SeleniumTest {
	private static WebDriver driver = Hooks.driver;
	public final static Logger logger = LogManager.getLogger(SeleniumTest.class);

	/**
	 * This function open the animana web ui
	 */
	@Given("^open animana web ui$")
	public void goToAnimana() {
		driver.get(Hooks.values.getValueUsingKey("animana_url"));
		driver.manage().window().maximize();
	}

	/**
	 * This functions enters username and password and click on login button
	 * 
	 * @throws Throwable
	 */
	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("testnl40");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Test#12345");
		driver.findElement(By.id("logon-login-button")).click();
	}

	/**
	 * This function validates that the login is successful by checking the test
	 * "choose location" on next page.
	 * 
	 * @throws Throwable
	 */
	@Then("^login is successfull$")
	public void login_is_successfull() throws Throwable {
		String actual_string = driver.findElement(By.xpath("//div[contains(text(),'choose location')]")).getText()
				.toLowerCase();
		Assert.assertEquals(actual_string, "choose location");
		logger.info("Login Successfully");
	}

	/**
	 * This function choose the location as Hilversum
	 * 
	 * @throws Throwable
	 */
	@When("^select location$")
	public void select_location() throws Throwable {
		driver.findElement(By.xpath("//input[@title='Hilversum']")).click();
		logger.info("Clicked on Hilversum");
	}

	/**
	 * This function validates the "new contact" icon after choosing the location as
	 * Hilversum after switching the frame.
	 * 
	 * @throws Throwable
	 */
	@Then("^validate new contact icon$")
	public void validate_new_contact_icon() throws Throwable {
		WebElement element = driver.findElement(By.xpath("//div[@id='manaDiv']/iframe"));
		driver.switchTo().frame(element);
		boolean is_present = driver.findElement(By.xpath("//a[@id='topMenuBar-addNewClient-button']")).isDisplayed();
		Assert.assertTrue("new contact icon is not present on the page", is_present);
	}

	/**
	 * This function selects the option "Patient" from search dropdown
	 * 
	 * @throws Throwable
	 */
	@When("^select patient from dropdown$")
	public void select_patient_from_dropdown() throws Throwable {
		driver.findElement(By.xpath("//button[@id='topMenuBar-searchDropdown-button']")).click();
		driver.findElement(By.xpath("//li/a[@beanname='patient']")).click();
		TimeUnit.SECONDS.sleep(3);
	}

	/**
	 * This function search for "Diensthond" and click on search
	 * 
	 * @throws Throwable
	 */
	@And("^search for a term$")
	public void search_for_a_term() throws Throwable {
		driver.findElement(By.xpath("//input[@name='searchkey']")).sendKeys("Diensthond");
		driver.findElement(By.xpath("//button[@id='mainSearchButton' and @beanname='patient']")).click();
	}

	/**
	 * This function asserts that the value "Diensthond" is present in the search
	 * results and switches the frame to default one.
	 * 
	 * @throws Throwable
	 */
	@Then("^assert search term$")
	public void assert_search_term() throws Throwable {
		boolean is_dien = driver.findElement(By.xpath("//td[contains(text(),'Diensthond')]")).isDisplayed();
		Assert.assertTrue(" Diensthond is not present in the page", is_dien);
		TimeUnit.SECONDS.sleep(3);
		driver.switchTo().defaultContent();
		logger.info("click successfull");
	}
}
