package com.maven.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datadriven.HashTable_Test;

public class Beehomes_sub {

	public WebDriver driver;
	String categoryName;

	@Test
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

	@Test
	public void use() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'service')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(),'sub-category')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@title='Add Sub category']")).click();
		System.out.println("clicked add button");

		Thread.sleep(2000);

		System.out.println("done>>>>>>>>>>>>>");
		driver.findElement(By.id("sub_category_file")).sendKeys("/home/rakesh/Downloads/Shifting homes.jpg");
		Thread.sleep(2000);

		driver.findElement(By.id("gallery_crop_btn")).click();

		System.out.println("clicked-crop");
		Thread.sleep(5000);

	}

	/*
	 * @Test(dataProvider = "category") public void use(HashMap<String, String> d)
	 * throws InterruptedException {
	 * 
	 * driver.findElement(By.xpath("//span[contains(text(),'service')]")).click();
	 * driver.findElement(By.xpath("//span[contains(text(),'sub-category')]")).click
	 * (); Thread.sleep(2000);
	 * 
	 * driver.findElement(By.xpath("//button[@title='Add Sub category']")).click();
	 * System.out.println("clicked add button");
	 * 
	 * Select a = new Select(driver.findElement(By.id("category_id"))); categoryName
	 * = d.get("Category"); a.selectByVisibleText(categoryName);
	 * System.out.println("done>>>>>>>>>>>>>");
	 * driver.findElement(By.id("sub_category_file")).
	 * sendKeys("/home/rakesh/Downloads/Shifting homes.jpg"); Thread.sleep(5000);
	 * 
	 * }
	 */
	// @Test(dataProvider = "subCategory")
	public void vuse(HashMap<String, String> d) {
		driver.findElement(By.id("sub-category-text")).sendKeys(d.get(categoryName + "-sub"));
		driver.findElement(By.id("sub-category-text-vi")).sendKeys(d.get(categoryName + "-sub-v"));

	}

	@DataProvider
	public Object[][] subCategory() throws IOException {
		return HashTable_Test.getData("/home/rakesh/Downloads/urban_clap.xlsx", "subcategory");
	}

	@DataProvider
	public Object[][] category() throws IOException {
		return HashTable_Test.getData("/home/rakesh/Downloads/urban_clap.xlsx", "category");
	}

}
