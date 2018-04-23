package com.maven.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datadriven.HashTable_Test;

public class Beehomes_adding {
	public WebDriver driver;

	//	@Test
	public void testBase() throws InterruptedException {
		File f = new File("/home/rakesh/Documents/eclipseworkspace/Appium/beehomes/file.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", p.getProperty("chromedriver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'SIGN')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'loginname')]")).sendKeys("9441658058");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.id("user_login")).click();
		Thread.sleep(3000);

	}

	@Test(dataProvider = "raki")
	public void use(HashMap<String, String> d) throws InterruptedException {
/*		try {
			driver.findElement(By.xpath("//button[@title='Add Category']")).click();
		} catch (Exception e) {
			driver.navigate().refresh();
			driver.findElement(By.xpath("//button[@title='Add Category']")).click();

		}
		driver.findElement(By.xpath("//input[@placeholder='Enter category']")).sendKeys(d.get("Category"));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[contains(@class,'vi')]")).sendKeys(d.get("Category-v"));
		Thread.sleep(1000);
		driver.findElement(By.id("category_file")).sendKeys("/home/rakesh/Downloads/" + d.get("Category") + ".jpg");
		Thread.sleep(1000);

		driver.findElement(By.id("addCategory")).click();
		Thread.sleep(1000);*/

		 System.out.println(d.get("Category"));

	}

	@DataProvider
	public Object[][] raki() throws IOException {
		return HashTable_Test.getData("/home/rakesh/Downloads/urban_clap.xlsx", "category");
	}

}