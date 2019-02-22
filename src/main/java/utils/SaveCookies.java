package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class SaveCookies {

	public static void testSaveCookie(WebDriver driver,String filePath)

	{

		File file = new File(filePath);
		try { // Delete if any old file exists
			file.delete();
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferwrite = new BufferedWriter(fileWriter);
			for (Cookie cook : driver.manage().getCookies()) {
				String writeup = cook.getName() + ";" + cook.getValue() + ";" + cook.getDomain() + ";" + cook.getPath()
						+ "" + ";" + cook.getExpiry() + ";" + cook.isSecure();
				bufferwrite.write(writeup);
				System.out.println(writeup);
				bufferwrite.newLine();
			}
			bufferwrite.flush();
			bufferwrite.close();
			fileWriter.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
