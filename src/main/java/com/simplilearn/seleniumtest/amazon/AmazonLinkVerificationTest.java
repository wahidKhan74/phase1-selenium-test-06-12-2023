package com.simplilearn.seleniumtest.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class demonstrate test for amazon webpage. *
 * 
 * @author khanw
 */
public class AmazonLinkVerificationTest {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

		// step4: launch browser
		driver.get(siteUrl);

		linkTest1();

		Thread.sleep(1000);

		linkTest2();

		Thread.sleep(1000);

		// step6: close driver
		driver.close();
	}

	/**
	 * Verify the Best seller link.
	 * 
	 * @throws InterruptedException
	 */
	private static void linkTest1() throws InterruptedException {

		Thread.sleep(1000);

		WebElement link = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));

		link.click();

		// add delay
		Thread.sleep(1000);

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

	/**
	 * Verify the Todays deals link.
	 * 
	 * @throws InterruptedException
	 */
	private static void linkTest2() throws InterruptedException {

		Thread.sleep(1000);

		WebElement link = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)"));

		link.click();

		// add delay
		Thread.sleep(1000);

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
