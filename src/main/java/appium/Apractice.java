package appium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.maven.sample.SeleniumBase;

public class Apractice extends SeleniumBase  {
	
	@Test
	private void testApractice() throws InterruptedException, IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println(screenshot.getAbsolutePath());
		

	}

}
