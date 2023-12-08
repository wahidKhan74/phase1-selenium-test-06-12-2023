package com.simplilearn.seleniumtest.webelement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrate CheckBox Test.
 * 
 * @author khanw
 *
 */
public class ChekboxTest {

	static WebDriver driver;

	public static void main(String[] args) {

		setUp();

		testCheckboxExist();
		
		testCheckbox2DefaultSelected();
		
		testCheckboxSelectedAndDeselect();

	}

	public static void setUp() {

		// step1: formulate a test domain url & driver path
		String siteUrl = "file:///C:/WaheedTraining/phase1-selenium-test-06-12-2023/static/web-elements.html";
		String driverPath = "drivers/windows/chromedriver.exe";

		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);

		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();

		// step4: add implicit wait (Unconditional Delay)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// step5: launch browser
		driver.get(siteUrl);
	}

	public static void testCheckboxExist() {

		WebElement vehicle1 = driver.findElement(By.id("vehicle1"));
		WebElement vehicle2 = driver.findElement(By.id("vehicle2"));
		WebElement vehicle3 = driver.findElement(By.id("vehicle3"));

		if (vehicle1.isDisplayed() && vehicle2.isDisplayed() && vehicle3.isDisplayed()) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}
	}

	public static void testCheckbox2DefaultSelected() {

		WebElement vehicle2 = driver.findElement(By.id("vehicle2"));
		
		if (vehicle2.isSelected()) {
			System.out.println("Test vehicle2 is selected  Passed !");
		} else {
			System.out.println("Test vehicle2 is selected is Failed !");
		}
	}
	
	
	public static void testCheckboxSelectedAndDeselect() {

		WebElement vehicle1 = driver.findElement(By.id("vehicle1"));
		WebElement vehicle2 = driver.findElement(By.id("vehicle2"));
		WebElement vehicle3 = driver.findElement(By.id("vehicle3"));

		vehicle1.click();   // select vehicle 1
		vehicle2.click();   // deselect vehicle 2
		vehicle3.click();   // select vehicle 1
		
		if (vehicle1.isSelected() && !vehicle2.isSelected() && vehicle3.isSelected()) {
			System.out.println("Test vehicle 1,3 is selected  and  vehicle 2 deselect Passed !");
		} else {
			System.out.println("est vehicle 1,3 is selected  and  vehicle 2 deselect is Failed !");
		}
	}
	
}
