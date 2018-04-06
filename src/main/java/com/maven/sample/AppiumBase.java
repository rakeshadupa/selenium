package com.maven.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lowagie.text.Row;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBase {
	AndroidDriver<AndroidElement> driver;
	@Test
	public void aTestBase() throws InterruptedException, MalformedURLException {
		File f = new File("src");
		File f1 = new File(f, "troop0803.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.login.login.LoginActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("9133559366");
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("recommend139");
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		Thread.sleep(40000);
		driver.findElementById("com.tvisha.troopmessenger:id/options").click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='1']").click();
//			TouchAction t=new TouchAction(driver);
//			System.out.println("try");
//			
//		t.tap(driver.findElementByXPath("//android.widget.LinearLayout[@index='1']")).perform();
//		
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='1']").click();
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='2']").click();
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='3']").click();
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='4']").click();

//		driver.findElementByXPath("//android.widget.TextView[text()='Password']").click();		
	//	driver.findElementByName("Password").click();
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(1).click();	
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(2).click();	
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(2).click();	
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(3).click();	


	}

	
	

}
