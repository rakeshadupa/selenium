package com.maven.sample;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Practice2 extends SeleniumBase {

	@Test
	private void vevo() throws InterruptedException, IOException {

		driver.get("https://www.echallan.org/publicview/");
		WebElement ele = driver.findElements(By.xpath("//img[@alt='captcha']")).get(0);

		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = ele.getLocation();

		// Get width and height of the element
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();

		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
		    eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		// Copy the element screenshot to disk
		File screenshotLocation = new File("/home/rakesh/Pictures/screenshot.png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		String a=Toast.VerifyForScreenshot(driver, eleScreenshot);
		System.out.println("text   "+a);
		
		
		driver.findElement(By.id("REG_NO")).sendKeys("TS07EV9092");
		driver.findElement(By.id("captchatab1")).sendKeys(a);
		driver.findElements(By.xpath("//input[@type='button']")).get(0).click();
		
	}

}