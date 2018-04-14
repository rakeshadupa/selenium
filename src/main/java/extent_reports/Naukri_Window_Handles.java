package extent_reports;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Naukri_Window_Handles{
	static WebDriver driver;

	@Test
	public void closeNaukriWindows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/rakesh/Documents/eclipseworkspace/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// It will open Naukri website with multiple windows
		driver.get("http://www.naukri.com/");
		
		// To get the main window handle
		String windowTitle= getCurrentWindowTitle();
		String mainWindow = getMainWindowHandle();
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"), "Main window title is not matching");
		Thread.sleep(2000);
		driver.close();
	}
		
	public String getMainWindowHandle() {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
}
