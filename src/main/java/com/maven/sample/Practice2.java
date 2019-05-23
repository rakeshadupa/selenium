package com.maven.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practice2 {

	WebDriver driver;
	@Test
	public void testGo() throws AWTException, InterruptedException, FileNotFoundException, IOException, ParseException {
		 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--allow-running-insecure-content");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		reUse("9133559366", "123456");
		Thread.sleep(5000);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
//		Thread.sleep(5000);
		// driver=new ChromeDriver();
		// reUse("rishisri.n@tvisha.in","qwerty");
		
		
		
		
		
		

	}

	public void reUse(String user, String pwd) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://192.168.2.48/troop_messenger_web/public/messenger");
		driver.findElement(By.xpath("//*[contains(text(),'LOGIN')]")).click();
		driver.findElement(By.name("email")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.id("bG9naW5CdG4")).click();
	}
}