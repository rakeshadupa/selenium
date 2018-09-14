package com.maven.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Goibibo extends SeleniumBase{

	@Test
	public void testGoibibo() throws InterruptedException
	{
		driver.get("https://www.goibibo.com/flights");
		driver.findElement(By.id("gi_roundtrip_label")).click();
		WebElement fromCity=driver.findElement(By.id("gosuggest_inputSrc"));
		fromCity.sendKeys("Bangalore");
		Thread.sleep(1000);
		fromCity.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		WebElement toCity=driver.findElement(By.id("gosuggest_inputDest"));
		toCity.sendKeys("mumbai");
		Thread.sleep(1000);
		toCity.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//div[contains(@class,'today')]/following-sibling::div[1]")).click();
		try {
		driver.findElement(By.xpath("//div[contains(@class,'today')]/following-sibling::div[3]")).click();
		}
		catch (NoSuchElementException e) {
			
		}
		driver.findElement(By.id("gi_search_btn")).click();
		
		
		
		
		
	
	
	}
}
