package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseEmulator {
	File filePath;
	 XSSFWorkbook w;
	public AndroidDriver<AndroidElement> testBaseEmulator(String emulator, int port, String mobile, String pwd)
			throws InterruptedException, MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		File f = new File("src");
		File f1 = new File(f, "troop.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel6");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.login.login.LoginActivity");
		cap.setCapability(MobileCapabilityType.UDID, emulator);

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:" + port + "/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys(mobile);
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys(pwd);
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		return driver;
	}
	public XSSFSheet exceldata(String sheetName) throws IOException
	{
		 filePath = new File("/home/rakesh/Documents/eclipse workspace/selenium_scripts/sample_maven_project/src/excelreport.xlsx");
		FileInputStream fis = new FileInputStream(filePath);
		 XSSFWorkbook w = new XSSFWorkbook(fis);

		XSSFSheet sheet = w.getSheet(sheetName);
		return sheet;
	}
	public void writeWorkBook() throws IOException
	{
		FileOutputStream fos = new FileOutputStream(filePath);
		w.write(fos);
	}
}
