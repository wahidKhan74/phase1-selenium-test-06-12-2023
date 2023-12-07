package com.simplilearn.seleniumtest.timeouts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will demonstrate Explicit wait based Test synchronization Implicit
 * Explicit wait : The explicit is used to tell the web driver to wait for a
 * certain condition or maximum time to be exceeded before throwing "Element Not
 * Visible exception".
 * 
 * @author khanw
 */
public class FacebookLoginTest {

	static WebDriver driver;
	static WebDriverWait wait;

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

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

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
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("#loginform > div:nth-child(12) > div._9ay7")));
		
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
