package com.maven.sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Practice3 extends SeleniumBase {

	@Test
	public void demo() throws InterruptedException {
		driver.navigate().to("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("rakesh");
		Thread.sleep(5000);
		driver.findElement(By.name("pasword")).sendKeys("123");
		driver.close();

	}
}