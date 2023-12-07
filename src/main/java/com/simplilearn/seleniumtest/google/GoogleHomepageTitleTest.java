package com.simplilearn.seleniumtest.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class demonstrate Launch google with FireFox Test. Selenium Webdriver
 * 
 * @author khanw
 *
 */
public class GoogleHomepageTitleTest {

	public static void main(String[] args) {
		
		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.google.com/";
		String driverPath = "drivers/windows/geckodriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		WebDriver driver = new FirefoxDriver();

		// step4: launch browser
		driver.get(siteUrl);

		// step5 : Evaluate the Test
		String title = "Google";
		
		if (title.equals(driver.getTitle())) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected title :: " + title);
		System.out.println("Actual title :: " + driver.getTitle());

		// step6: Close browser
		driver.close();
	}
}
