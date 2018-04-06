package practice;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import two_emulators.One;

public class Emulator2 implements Runnable {
	int j = 1;
	AndroidDriver<WebElement> driver;

	public void run() {
		BaseEmulator be = new BaseEmulator();
		AndroidDriver<AndroidElement> driver;
		try {
			driver = be.testBaseEmulator("emulator-5554", 5000, "mobile", "pwd");
			Thread.sleep(10000);
			XSSFSheet writeSheet = be.exceldata("test");

			int readlastRowNo = writeSheet.getLastRowNum();
			for (int i = 0; i <= readlastRowNo - 1; i++) {
				Thread.sleep(5000);
				if (driver.findElementById("com.tvisha.troopmessenger:id/unreadMesgCount").isDisplayed()) {
					String sentMsg = One.sentMessage;

					driver.findElementsById("com.tvisha.troopmessenger:id/item").get(0).click();
					Thread.sleep(7000);
					int a = driver.findElementsByXPath(
							"//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout")
							.size();

					String actMsg = driver.findElementByXPath(
							"//android.support.v7.widget.RecyclerView[@index='0']//android.widget.RelativeLayout[@index='"
									+ (a - 1) + "']//android.widget.TextView[@index='0']")
							.getText();
					System.out.println(actMsg);
					driver.pressKeyCode(AndroidKeyCode.BACK);

					writeSheet.getRow(i + 1).createCell(j + 1).setCellValue(actMsg);
					System.out.println("set cell value " + actMsg);
					if (sentMsg.equals(actMsg)) {
						writeSheet.getRow(i + 1).createCell(j + 2).setCellValue("passed");
						System.out.println("passed");

					} else {
						writeSheet.getRow(i + 1).createCell(j + 2).setCellValue("failed");
						System.out.println("failed");
					}

				}

			}
			be.writeWorkBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
