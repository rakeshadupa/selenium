package com.maven.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javascript.HighlightElement;

public class Practice1 extends SeleniumBase {
	@Test
	public void demo() throws InterruptedException {

	driver.get("https://rakesh:adupa@www.engprod-charter.net/");
		
		
		
		
		
/*		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement userName = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));

		HighlightElement.makeElementFlash(driver, userName);
		userName.sendKeys("rakesh");
		HighlightElement.makeElementFlash(driver, password);

		password.sendKeys("adupa");
		HighlightElement.makeElementFlash(driver, login);


		driver.close();
	*/
	}

}
