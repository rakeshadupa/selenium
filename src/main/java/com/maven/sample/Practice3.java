package com.maven.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.StaleElementUtils;

public class Practice3 extends SeleniumBase {

	@Test
	public void demo() throws InterruptedException, AWTException {

		driver.get("https://www.freecrm.com/index.html");
		WebElement ele = driver.findElement(By.name("username"));
		driver.navigate().refresh();

		// WebElement newEle = StaleElementUtils.refreshElement(ele, driver);
		//
		// newEle.sendKeys("rakesh");

		/*
		 * for (WebElement webElement : sa) { System.out.println(
		 * ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
		 * ); WebElement newEle= StaleElementUtils.refreshElement(webElement,driver);
		 * 
		 * 
		 * 
		 * System.out.println("text is --------"+newEle.getText()); // driver.close(); }
		 */
	}
}