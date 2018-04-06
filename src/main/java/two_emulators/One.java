package two_emulators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class One implements Runnable{

public 	static String sentMessage;
public void run()
{
	AndroidDriver<WebElement> driver;
   	 File f = new File("src");
		File f1 = new File(f, "troop.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel6");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.login.login.LoginActivity");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5556");
		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(10000);

			driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("9133559366");
			driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("recommend139");
			driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click(); 
			Thread.sleep(10000);
			driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();
			driver.findElementById("com.tvisha.troopmessenger:id/search").sendKeys("sabyasachi panda");
			driver.findElementById("com.tvisha.troopmessenger:id/userName").click();
			File fPath = new File("/home/rakesh/Documents/eclipse workspace/selenium_scripts/sample_maven_project/src/excelreport.xlsx");
			FileInputStream fis = new FileInputStream(fPath);
			 XSSFWorkbook w = new XSSFWorkbook(fis);

			XSSFSheet read = w.getSheet("msgdata");
			int readlastRowNo = read.getLastRowNum();
			for (int i = 0; i <= readlastRowNo - 1; i++) {
				sentMessage = read.getRow(i + 1).getCell(0).getStringCellValue();
				System.out.println("sending  "+sentMessage);
				Thread.sleep(2000);
				driver.findElementById("com.tvisha.troopmessenger:id/newMesg").sendKeys(sentMessage);
				driver.findElementById("com.tvisha.troopmessenger:id/sendMessage").click();
				Thread.sleep(8000);
			}
		}
			
	 catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
}
