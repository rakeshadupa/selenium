package com.maven.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Practice3 extends SeleniumBase {

	@Test
	public void demo() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elev = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));

	}
}