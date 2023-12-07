package com.simplilearn.seleniumtest.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class demonstrate test for amazon webpage. * 
 * @author khanw
 */
public class AmazonHompageTest {

	public static void main(String[] args) {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/windows/geckodriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.geckodriver.driver", driverPath);

		// step3: instantiate selenium webdriver
		WebDriver driver = new FirefoxDriver();

		// step4: launch browser
		driver.get(siteUrl);
		
		String expectedTitle  = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle  = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}
		
		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
		
		
		// step6: close driver
		driver.close();
	}
}
