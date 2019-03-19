package com.maven.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class Practice1 extends SeleniumBase {

	@Test

	public void installapp() throws InterruptedException, IOException, AWTException {
		

		driver.get("http://dev.mrmsbeautysalon.com");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_SPACE);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("D:\\Rakesh\\test.png"));
		driver.close();
		

	}

}
