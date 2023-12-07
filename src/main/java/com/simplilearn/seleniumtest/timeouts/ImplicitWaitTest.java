package com.simplilearn.seleniumtest.timeouts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class will demonstrate Implicit wait based Test synchronization Implicit
 * wait : The implicit in selenium is used for tell the web driver to wait for a
 * certain time before it throw a "No Such element exception" default implicit
 * setting is 0.
 * 
 * @author khanw
 *
 */
public class ImplicitWaitTest {

	static WebDriver driver = null;

	public static void main(String[] args) {

		setUp();

		testMobileNavLink();

		testBestSellerNavLink();
	}

	public static void setUp() {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

		// step4: add implicit wait (Unconditional Delay)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// step5: launch browser
		driver.get(siteUrl);
	}

	public static void testMobileNavLink() {

		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(7)"));

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

	public static void testBestSellerNavLink() {

		WebElement bestsellerLink  = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(5)"));

		System.out.println("Is link loaded :: " + bestsellerLink .isDisplayed());
		System.out.println("Is link is enabled :: " + bestsellerLink .isEnabled());

		bestsellerLink .click();

		String expectedTitle = "Amazon.in Bestsellers: The most popular items on Amazon";
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
