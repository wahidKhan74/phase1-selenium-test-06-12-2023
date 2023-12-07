package com.simplilearn.seleniumtest.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class demonstrate test script for seach on google search engine.
 * Selenium Webdriver
 * @author khanw
 *
 */
public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.google.com/";
		String driverPath = "drivers/windows/geckodriver.exe";
		
		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);
		
		// step3: instantiate selenium webdriver
		WebDriver driver = new FirefoxDriver();
		
		// step4: launch browser
		driver.get(siteUrl);
		
		// steps5: Evaluate Test
		// locate search box
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium documentation");
		searchBox.submit();
		
		// add delay
		Thread.sleep(2000);
		
		String expectedTitle = "selenium documentation - Google Search";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}
		
		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
		
		// step5: close driver
		driver.close();
		
		
	}
}
