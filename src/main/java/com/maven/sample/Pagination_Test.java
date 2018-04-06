package com.maven.sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Pagination_Test {
	@Test
public void testPagination() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "/home/rakesh/Documents/eclipse workspace/chromedriver");
	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.troopcrm.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("8331848243");
		driver.findElement(By.id("password")).sendKeys("Tvisha@123");
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.className("task_icon")).click();
		List<WebElement> pagination = driver.findElements(By.className("paginate_button"));
		int size = pagination.size();
		// System.out.println(size);

		for (int i = 2; i < size; i++) {

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.xpath(".//*[@id='todoTaskTableData_paginate']/ul/li[" + i + "]/a")).click();
			List<WebElement> tasks = driver.findElements(By.xpath(".//*[@id='todoTaskBody']/tr/td[1]"));
			System.out.println("Number of tasks in page " + (i-1) + " are " + tasks.size());

		}

	Thread.sleep(3000);
		
	}
}
