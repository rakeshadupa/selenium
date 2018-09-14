package com.maven.sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Practice1 extends SeleniumBase {
	@Test
	public void testDemo() {

		
		
		driver.get("https://www.troopcrm.com");
		driver.findElement(By.id("username")).sendKeys("123456");
		System.err.println("text"+driver.findElement(By.id("username")).getAttribute("value"));
	}
}
