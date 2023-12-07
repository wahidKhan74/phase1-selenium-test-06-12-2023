package com.simplilearn.seleniumtest.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class demonstrate test for amazon webpage. *
 * 
 * @author khanw
 */
public class AmazonSearchTest {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/geckodriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new FirefoxDriver();

		// step4: launch browser
		driver.get(siteUrl);

		testSearch1();
		
		testSearch2();
		
		Thread.sleep(2000);
		
		driver.close();
	}

	/**
	 * Search for a product.
	 * @throws InterruptedException 
	 */
	private static void testSearch1() throws InterruptedException {

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 15 pro max");
		searchBox.submit();

		// add delay 
		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : Iphone 15 pro max";
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
	 * Search for a product.
	 * @throws InterruptedException 
	 */
	private static void testSearch2() throws InterruptedException {

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.clear();
		searchBox.sendKeys("Apple Mac book");
		searchBox.submit();

		// add delay 
		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : Apple Mac book";
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
