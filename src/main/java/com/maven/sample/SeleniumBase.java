package com.maven.sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeleniumBase {
	public  WebDriver  driver=null;

	String browser = "chrome";
	@BeforeClass
	public void testSeleniumBase( ) throws InterruptedException, IOException {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			//options.addArguments("disable-infobars");
			// options.addArguments("start-maximized");
			//options.addArguments("--ignore-certificate-errors");
			//options.addArguments("--disable-popup-blocking");
			// options.addArguments("--incognito");
			driver = new ChromeDriver(options);

			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/geckodriver");
			FirefoxProfile profile = new FirefoxProfile();
			driver = new FirefoxDriver();

			break;
		default:
			System.err.println("<<<<<<<<<<<You have set wrong browser name>>>>>>>>>>>>>>>>>>>");
			break;
		}

		/*
		 * EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		 * WebEventListener listnr = new WebEventListener(); e_driver.register(listnr);
		 * driver = e_driver;
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

//	@AfterClass
	public void afterTest() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
		// driver=null;
	}

}
