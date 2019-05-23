package com.maven.sample;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBase {
	public WebDriver driver = null;

	String browser = "chrome";

	@BeforeClass
	public void testSeleniumBase() throws InterruptedException, IOException {

		switch (browser) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
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

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// @AfterClass
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
