package com.maven.sample;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicTest {

	static WebDriver driver;

	@Test
	public void testSeleniumBase() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/home/rakesh/Documents/eclipseworkspace/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pizzahut.co.in/customer-feedback.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("sdfsa")).click();
		List<WebElement> anchors = driver.findElements(By.tagName("a"));
		Iterator<WebElement> i = anchors.iterator();

		while (i.hasNext()) {
			WebElement anchor = i.next();
			if (anchor.getAttribute("href").contains("dinein")) {
				anchor.click();
				break;
			}
		}
	}

	// driver.findElement(By.linkText("Dine in Feedback")).click();
}
