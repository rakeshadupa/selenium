package practice;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Emulator1 implements Runnable {
	public static String sentMessage;

	public void run() {
		BaseEmulator be = new BaseEmulator();

		AndroidDriver<AndroidElement> driver;
		try {
			driver = be.testBaseEmulator("emulator-5556", 4723, "9133559366", "");

			Thread.sleep(10000);

			driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();
			driver.findElementById("com.tvisha.troopmessenger:id/search").sendKeys("sabyasachi panda");
			driver.findElementById("com.tvisha.troopmessenger:id/userName").click();
			XSSFSheet readSheet = be.exceldata("msgdata");
			int readlastRowNo = readSheet.getLastRowNum();
			for (int i = 0; i <= readlastRowNo - 1; i++) {
				sentMessage = readSheet.getRow(i + 1).getCell(0).getStringCellValue();
				System.out.println("sending  " + sentMessage);
				Thread.sleep(2000);
				driver.findElementById("com.tvisha.troopmessenger:id/newMesg").sendKeys(sentMessage);
				driver.findElementById("com.tvisha.troopmessenger:id/sendMessage").click();
				Thread.sleep(8000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}