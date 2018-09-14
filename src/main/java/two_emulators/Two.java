package two_emulators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class Two implements Runnable {
	int jx = 1;
	AndroidDriver<WebElement> driver;

	public void run() {

		File f = new File("src");
		File f1 = new File(f, "troopm.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel6");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.login.login.LoginActivity");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		try {

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4726/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("reciever username");
			driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("reciever password");
			driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
			Thread.sleep(10000);
			File fx = new File("/home/rakesh/Documents/eclipse workspace/selenium_scripts/sample_maven_project/src/excelreport.xlsx");
			FileInputStream fis = new FileInputStream(fx);
			XSSFWorkbook wr = new XSSFWorkbook(fis);
			XSSFSheet sh = wr.getSheet("test");
			int readlastRowNo = sh.getLastRowNum();
			for (int i = 0; i <= readlastRowNo - 1; i++) {
				Thread.sleep(5000);
				if (driver.findElementById("com.tvisha.troopmessenger:id/unreadMesgCount").isDisplayed()) {
					String sentMsg = One.sentMessage;

					driver.findElementsById("com.tvisha.troopmessenger:id/item").get(0).click();
					Thread.sleep(7000);
					int a = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout").size();
					// System.out.println(i);
					String actMsg = driver.findElementByXPath("//android.support.v7.widget.RecyclerView[@index='0']//android.widget.RelativeLayout[@index='"+ (a - 1) + "']//android.widget.TextView[@index='0']").getText();
					System.out.println(actMsg);
					driver.pressKeyCode(AndroidKeyCode.BACK);

					// sh.getRow(i + 1).createCell(jx).setCellValue(message);

					sh.getRow(i + 1).createCell(jx + 1).setCellValue(actMsg);
					System.out.println("set cell value " + actMsg);
					if (sentMsg.equals(actMsg)) {
						sh.getRow(i + 1).createCell(jx + 2).setCellValue("passed");
						System.out.println("passed");

					} else {
						sh.getRow(i + 1).createCell(jx + 2).setCellValue("failed");
						System.out.println("failed");
					}

					// System.out.println(i + "*****" + jx);

				}

			}
			FileOutputStream fos = new FileOutputStream(fx);
			wr.write(fos);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
