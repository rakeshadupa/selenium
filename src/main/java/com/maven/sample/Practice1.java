package com.maven.sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import javascript.HighlightElement;

public class Practice1 extends SeleniumBase {

	
	@Test
	private void test() throws InterruptedException {
driver.get("https://www.freecrm.com/index.html");
HighlightElement.makeElementFlash(driver, driver.findElement(By.name("username")));

	}
}