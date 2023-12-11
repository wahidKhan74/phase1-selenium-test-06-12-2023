package com.simplilearn.seleniumtest.profile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will demonstrate browser profile.
 * 
 * @author khanw
 *
 */
public class BrowserProfileTest {

	static WebDriver driver;
	static WebDriverWait wait;
	static ChromeOptions options;
	
 
	public static void main(String[] args) {

		setUp();

		testFailureLogin();
	}

	public static void setUp() {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.facebook.com";
		String driverPath = "drivers/windows/chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:/Users/khanw/AppData/Local/Google/Chrome/User Data");
		options.addArguments("--profile-directory=Profile 6");
		
		// step3: instantiate selenium webdriver
		driver = new ChromeDriver(options);

		// step4: add explicit wait (Conditional Delay)
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		// step5: launch browser
		driver.get(siteUrl);
	}

	public static void testFailureLogin() {

		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc@123");
		driver.findElement(By.name("login")).submit();

		// evaluate a failure login test
		WebElement errorMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#loginform > div:nth-child(12) > div._9ay7")));

		String errorText = "The password that you've entered is incorrect. Forgotten password?";

		if (errorText.equals(errorMsg.getText())) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected Error Text : " + errorText);
		System.out.println("Actual Error Text : " + errorMsg.getText());
	}
}
