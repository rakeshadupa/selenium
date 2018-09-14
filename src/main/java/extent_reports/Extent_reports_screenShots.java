/*package extent_reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_reports_screenShots {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest extentTest;
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReporterWithScreenshots.html", true);
		extent.addSystemInfo("Host Name", "rakesh tvisha");
		extent.addSystemInfo("User Name", "rakesh adupa");
		extent.addSystemInfo("Environment", "QA");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/home/rakesh/Documents/eclipseworkspace/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.sugarcrm.com/");

	}

	@Test
	public void freeCrmTitleTest() {
		extentTest = extent.startTest("sugarcrm title first");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Customer Relationship Management Software | SugarCR");
		extentTest.log(LogStatus.INFO, "this is the log status==========================");

	}
	
	@Test
	public void freemCRMLogoTest() throws InterruptedException {
		extentTest = extent.startTest("freemCRMLogoTest");
		driver.findElement(By.xpath("//a[contains(text(),'Free')]")).click();
		driver.findElement(By.id("FirstName")).sendKeys("rakesh");
		Thread.sleep(5000);
		assertEquals("Sugar Fre Trial | SugarCRM", driver.getTitle(),"not matched");
		
	
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent_reports
																						// report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent_reports report

			String screenshotPath = Extent_reports_screenShots.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in
																							// extent_reports report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent_reports report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report
		driver.quit();
	}

}*/