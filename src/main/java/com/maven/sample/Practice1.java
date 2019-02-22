package com.maven.sample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Practice1 {

	WebDriver driver;

	@Test

	public void installapp() throws MalformedURLException, InterruptedException {

		File f = new File("src");

		File fr = new File(f, "customer.apk");

		DesiredCapabilities capa = new DesiredCapabilities();

		capa.setCapability(MobileCapabilityType.DEVICE_NAME, "Device");
		capa.setCapability("autoGrantPermissions", "true");
		capa.setCapability("waitForAppScript", "true");

		capa.setCapability(MobileCapabilityType.APP, fr.getAbsolutePath());

		capa.setCapability("appPackage", "com.tvisha.mrandmrs");
		capa.setCapability("appActivity", "com.tvisha.mrandmrs.screens.homescreen.HomeScreenActivity");
		capa.setCapability("noReset", true);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capa);

//		capa.setCapability("newCommandTimeout", 60);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(By.id("com.tvisha.mrandmrs:id/first_name")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.ImageButton")).click();
		driver.findElement(By.id("com.tvisha.mrandmrs:id/nav_email")).click();
		
//		
//		System.err.println(driver.findElements(By.id("com.tvisha.mrandmrs:id/first_name")).size());
//		
////		System.out.println(driver.findElement(By.id("com.tvisha.mrandmrs:id/last_name")).getText());
//		driver.findElements(By.id("com.tvisha.mrandmrs:id/first_name")).get(0).click();
		System.out.println( driver.findElements(By.xpath("//android.widget.EditText")).size());
		
		System.exit(0);
		for (WebElement iterable_element : driver.findElements(By.xpath("//android.widget.EditText"))) {
			System.out.println(iterable_element.getText());
			
		}
		System.exit(0);
	
		

	}

}
