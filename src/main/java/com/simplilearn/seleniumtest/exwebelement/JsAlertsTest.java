package com.simplilearn.seleniumtest.exwebelement;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class demonstrate JavaScript Alerts Automation Test.
 * 
 * @author khanw
 *
 */
public class JsAlertsTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		setUp();

		// test alert
		testAlert();

		// test confirmation alert
		testConfirmDailogAlert1();
		testConfirmDailogAlert2();

		// test prompt alert accept
		testPromptDailogAlert1();
		testPromptDailogAlert2();
	}

	public static void setUp() {

		// step1: formulate a test domain url & driver path
		String siteUrl = "file:///C:/WaheedTraining/phase1-selenium-test-06-12-2023/static/alert-web-elements.html";
		String driverPath = "drivers/windows/geckodriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new FirefoxDriver();

		// step4: add implicit wait (Unconditional Delay)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// step5: launch browser
		driver.get(siteUrl);
	}

	public static void testAlert() throws InterruptedException {
		// find alert button and click
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button:nth-child(1)")).click();

		// switch to sub alert window
		Alert alert = driver.switchTo().alert();

		String expText = "Do you really want to proceed ??";
		if (expText.equals(alert.getText())) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}

		Thread.sleep(2000);

		// accept the alert
		alert.accept();
	}

	// Test confirmation alert and accept
	public static void testConfirmDailogAlert1() throws InterruptedException {
		// find alert button and click
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button:nth-child(1)")).click();

		// switch to sub confirmation alert window
		Alert alert = driver.switchTo().alert();

		String expText = "Please confirm the action is right ??";
		if (expText.equals(alert.getText())) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}

		Thread.sleep(2000);

		// accept the alert
		alert.accept();
	}

	// Test confirmation alert and cancel
	public static void testConfirmDailogAlert2() throws InterruptedException {
		// find alert button and click
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button:nth-child(1)")).click();

		// switch to sub confirmation alert window
		Alert alert = driver.switchTo().alert();

		String expText = "Please confirm the action is right ??";
		if (expText.equals(alert.getText())) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}

		Thread.sleep(2000);

		// cancel the alert
		alert.dismiss();
	}

	// Test prompt alert and accpet
	public static void testPromptDailogAlert1() throws InterruptedException {
		// find alert button and click
		driver.findElement(By.xpath("/html/body/p[6]/button")).click();

		// switch to sub confirmation alert window
		Alert propmt = driver.switchTo().alert();

		String expText = "Please enter your name.";
		if (expText.equals(propmt.getText())) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}

		Thread.sleep(2000);

		// cancel the alert
		propmt.accept();
	}

	// Test prompt alert and cancel
	public static void testPromptDailogAlert2() throws InterruptedException {
		// find alert button and click
		driver.findElement(By.xpath("/html/body/p[6]/button")).click();

		// switch to sub confirmation alert window
		Alert propmt = driver.switchTo().alert();

		String expText = "Please enter your name.";
		
		propmt.sendKeys("John Smith");
		
		if (expText.equals(propmt.getText())) {
			System.out.println("Test is passed !");
		} else {
			System.out.println("Test is failed !");
		}

		Thread.sleep(2000);

		// cancel the alert
		propmt.dismiss();
	}

}
