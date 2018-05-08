package com.maven.sample;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.UtilityClass;

public class Practice3 extends SeleniumBase {

	@Test
	public void demo() throws InterruptedException, AWTException {
		driver.get("https://www.troopcrm.com/");
		driver.findElement(By.id("username")).sendKeys("9133559366");
		driver.findElement(By.id("password")).sendKeys("recommend139");
		driver.findElement(By.id("loginBtn")).click();
		UtilityClass.exWaitForVisibleLocated(driver, 10, By.id("filter_agreements_btn"));
		

		
		
		
		
	}
}