package com.maven.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javascript.HighlightElement;

public class Practice1 extends SeleniumBase {

	@Test
	private void test() throws InterruptedException, AWTException {
		driver.get("http://192.168.2.60/beehomes_development/public/");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,1000)");

		List<WebElement> l = driver.findElements(By.xpath("//div[@class='detail_service_all detail_service one']"));
		int count = 5;
		for (int i = 0; i < l.size(); i++) {
			String s1 = l.get(i).getText().replaceAll("Book", "").trim();
			System.out.println(s1);
			if ("Sad".equals(s1)) {
				System.out.println("matched");
				l.get(i).click();
			}
			if (i == count) {
				
				WebElement next = driver.findElements(By.xpath("//div[@class='owl-next']")).get(1);
				next.click();
				next.click();
				next.click();
				count = count + 6;

			}
		}

	}
}