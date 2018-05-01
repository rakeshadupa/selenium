package com.maven.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.testng.annotations.Test;

public class Practice3 extends SeleniumBase {

	@Test
	public void demo() {
		driver.navigate().to("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("rakesh");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.close();

	}
}