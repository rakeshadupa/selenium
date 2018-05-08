package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {

	public static void takeScreenshot(WebDriver driver, String exceptionName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentPath = System.getProperty("user.dir");
		FileUtils.copyFile(src,
				new File(currentPath + "/screenshots/" + System.currentTimeMillis() + exceptionName + ".png"));

	}

	public static void exWaitForClickable(WebDriver driver, int time, WebElement element) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void exWaitForVisible(WebDriver driver, int time, WebElement element) {
		
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public static void exWaitForVisibleLocated(WebDriver driver, int time, By locator) {
		
		new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
	}
}
