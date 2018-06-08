package com.maven.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Mobile_CHROME {
	WebDriver driver;

	@Test
	public void testMobile() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver");

		Map<String, String> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Nexus 5");
		// (OR)
		// mobileEmulation.put(MobileCapabilityType.DEVICE_NAME, "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		driver = new ChromeDriver(chromeOptions);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.troopcrm.com/");
		driver.findElement(By.id("username")).sendKeys("9133559366");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.id("loginBtn")).click();
	}

}
