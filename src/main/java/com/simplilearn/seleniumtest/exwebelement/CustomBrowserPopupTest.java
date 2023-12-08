package com.simplilearn.seleniumtest.exwebelement;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomBrowserPopupTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		setUp();

		// test alert
		testCustomPopup();

	}

	public static void setUp() {

		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.amazon.in/";
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
	
	public static void testCustomPopup() throws InterruptedException {
		// find location popup and click
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		
		Thread.sleep(3000);
		
		// find current window
		String mainWindow = driver.getWindowHandle();
		
		// list of external popups
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			
			// Switch to child window
			driver.switchTo().window(childWindow);
			
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500001");
			
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span:nth-child(1) > input:nth-child(1)")).click();
			
		}
		
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
		
	}
}
