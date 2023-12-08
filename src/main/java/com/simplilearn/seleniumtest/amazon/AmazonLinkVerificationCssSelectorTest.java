package com.simplilearn.seleniumtest.amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class demonstrate test CSS Selector *
 * 
 * @author khanw
 */
public class AmazonLinkVerificationCssSelectorTest {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {

		setUp();

		mobileLinkTest();

		tdLinkTest2();

		driver.close();
	}

	public static void setUp() {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

		// step4: add explicit wait (Conditional Delay)
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// step5: launch browser
		driver.get(siteUrl);
	}

	// Relative CSS selector
	public static void mobileLinkTest() {

		WebElement mobileLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(7)")));

		System.out.println("Is link loaded :: " + mobileLink.isDisplayed());
		System.out.println("Is link is enabled :: " + mobileLink.isEnabled());

		mobileLink.click();

		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
	}

	public static void tdLinkTest2() {

		WebElement tdLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(6)")));

		System.out.println("Is link loaded :: " + tdLink.isDisplayed());
		System.out.println("Is link is enabled :: " + tdLink.isEnabled());

		tdLink.click();

		String expectedTitle = "Amazon.in - Deals";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
	}
}
