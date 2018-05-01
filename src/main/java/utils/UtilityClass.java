package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {

	public static void takeScreenshot(WebDriver driver,String exceptionName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentPath = System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(currentPath + "/screenshots/" + System.currentTimeMillis() +exceptionName+ ".png"));
		//
		
		
	
		
	}
}
