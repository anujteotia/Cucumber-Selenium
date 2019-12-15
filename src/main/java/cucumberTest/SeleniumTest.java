package cucumberTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

	public static WebDriver driver = null;
	public static ChromeOptions options = new ChromeOptions();

	@Test
	public static void main(String[] args) throws InterruptedException {

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://test.animana.com/web2/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("testnl40");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Test#12345");
		driver.findElement(By.id("logon-login-button")).click();
		String actual_string = driver.findElement(By.xpath("//div[contains(text(),'choose location')]")).getText()
				.toLowerCase();
		System.out.println(actual_string);
		Assert.assertEquals(actual_string, "choose location");
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Login Successfully");
		driver.findElement(By.xpath("//input[@title='Hilversum']")).click();
		System.out.println("Clicked on Hilversum");
		WebElement element = driver.findElement(By.xpath("//div[@id='manaDiv']/iframe"));
		driver.switchTo().frame(element);
		boolean is_present = driver.findElement(By.xpath("//a[@id='topMenuBar-addNewClient-button']")).isDisplayed();
		Assert.assertTrue("new contact icon is not present on the page", is_present);
		driver.findElement(By.xpath("//button[@id='topMenuBar-searchDropdown-button']")).click();
		driver.findElement(By.xpath("//li/a[@beanname='patient']")).click();
		TimeUnit.SECONDS.sleep(5);
		driver.findElement(By.xpath("//input[@name='searchkey']")).sendKeys("Diensthond");
		driver.findElement(By.xpath("//button[@id='mainSearchButton' and @beanname='patient']")).click();
		boolean is_dien = driver.findElement(By.xpath("//td[contains(text(),'Diensthond')]")).isDisplayed();
		Assert.assertTrue(" Diensthond is not present in the page", is_dien);
		TimeUnit.SECONDS.sleep(5);
		driver.switchTo().defaultContent();
		System.out.println("click successfull");
		
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Unable to quit the WebDriver");
			throw e;
		}

	}

}
