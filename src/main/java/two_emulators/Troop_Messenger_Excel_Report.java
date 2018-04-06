package two_emulators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Troop_Messenger_Excel_Report {
	
		AndroidDriver<AndroidElement> driver;
		File fx;
		XSSFWorkbook wr;
		int jx = 1;

		@Test
		public void aTestBase() throws InterruptedException, MalformedURLException {
			File f = new File("src");
			File f1 = new File(f, "troop.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
			cap.setCapability("autoGrantPermissions", true);
			cap.setCapability("unicodeKeyboard", true);
			cap.setCapability("resetKeyboard", true);
			cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.login.login.LoginActivity");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("9133559366");
			driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("recommend139");
			driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
			Thread.sleep(10000);
			driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();
			driver.findElementById("com.tvisha.troopmessenger:id/search").sendKeys("panda");
			driver.findElementById("com.tvisha.troopmessenger:id/userName").click();
		}
		@Test
		public void sendMsg() throws IOException, InterruptedException {

			fx = new File("/home/rakesh/Documents/eclipse workspace/selenium_scripts/sample_maven_project/src/excelreport.xlsx");
			FileInputStream fis = new FileInputStream(fx);
			wr = new XSSFWorkbook(fis);
			XSSFSheet read = wr.getSheet("msgdata");
			int readlastRowNo = read.getLastRowNum();
			XSSFSheet write = wr.getSheet("test");
			for (int i = 0; i <= readlastRowNo - 1; i++) {
				String message = read.getRow(i + 1).getCell(0).getStringCellValue();
				driver.findElementById("com.tvisha.troopmessenger:id/newMesg").sendKeys(message);
				driver.findElementById("com.tvisha.troopmessenger:id/sendMessage").click();
				Thread.sleep(3000);
				int a = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout").size();
				System.out.println(i);
				String actMsg = driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@index='0']//android.widget.RelativeLayout[@index='" + (a-1)+ "']//android.widget.LinearLayout[@index='0']//android.widget.TextView[@index='0']").getText();
				System.out.println(actMsg);


				write.getRow(i + 1).createCell(jx).setCellValue(message);

				write.getRow(i + 1).createCell(jx + 1).setCellValue(actMsg);

				if (message.equals(actMsg)) {
					write.getRow(i + 1).createCell(jx + 2).setCellValue("passed");

				} else {
					write.getRow(i + 1).createCell(jx + 2).setCellValue("failed");

				}

				System.out.println(i + "*****" + jx);

			}
		}

		@Test
		public void z() throws IOException {

			FileOutputStream fos = new FileOutputStream(fx);
			wr.write(fos);
		}

		

	}

