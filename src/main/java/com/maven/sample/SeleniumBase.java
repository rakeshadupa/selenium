package com.maven.sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import javascript.BrokenLinks;

public class SeleniumBase {
	public WebDriver driver;

	String browser = "chrome";

	@BeforeTest
	public void testSeleniumBase() throws InterruptedException, IOException {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/home/rakesh/Documents/eclipseworkspace/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("start-maximized");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-popup-blocking");
			// options.addArguments("--incognito");
			driver = new ChromeDriver(options);

			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "/home/rakesh/Documents/eclipseworkspace/geckodriver");
			FirefoxProfile profile = new FirefoxProfile();
			driver = new FirefoxDriver();

			break;
		default:
			System.err.println("<<<<<<<<<<<You have set wrong browser name>>>>>>>>>>>>>>>>>>>");
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	// @AfterTest
	public void afterTest() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.close();
	}

}
