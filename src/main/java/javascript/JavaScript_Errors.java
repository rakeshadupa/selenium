package javascript;

import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScript_Errors {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/rakesh/Documents/eclipseworkspace/chromedriver");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences loggingprefs = new LoggingPreferences();
		loggingprefs.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		driver = new ChromeDriver(capabilities);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	public void ExtractJSLogs() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.err.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			
		}
	}

	@Test
	public void testMethod() {
		driver.get("https://www.sugarcrm.com/");
		ExtractJSLogs();
	}
}
