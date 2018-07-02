package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maven.sample.SeleniumBase;

public class Otp extends SeleniumBase {
	private static List<WebElement> listOfColoumns;
	private static int coloumnsSize;

	
	public static int getOtpFromPhpMyadmin(WebDriver driver, String url,String projectName, String tableName,String userName, String pwd, String mobile)
			throws InterruptedException {
		String stringOtp = null;

		driver.get(url);
		driver.findElement(By.id("input_username")).sendKeys(userName);
		driver.findElement(By.id("input_password")).sendKeys(pwd);
		driver.findElement(By.id("input_go")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+projectName+"')]")).click();
		driver.findElement(By.xpath("//a[text()='"+tableName+"']")).click();
		Thread.sleep(3000);
		listOfColoumns = driver.findElements(By.xpath("//tr/th"));
		coloumnsSize = listOfColoumns.size();
		int mobileIndex;
		int otpIndex;
		mobileIndex = coloumnIndex("mobile") - 1;
		otpIndex = coloumnIndex("otp") - 1;
		int difference = otpIndex - mobileIndex;
		if (difference < 0) {
			difference = -difference;
		}

		for (int k = mobileIndex; k < 1000; k = k + coloumnsSize - 1) {
			String s = driver.findElements(By.xpath("//tr/td[contains(@class,'grid')]")).get(k).getText();
			System.out.println("mobile number" + s);

			if (s.equals(mobile)) {

				stringOtp = driver.findElements(By.xpath("//tr/td[contains(@class,'grid')]")).get(k + difference)
						.getText();
				System.out.println(stringOtp);
				break;
			}
		}
		return Integer.parseInt(stringOtp);
	}

	private static int coloumnIndex(String coloumnName) {
		int j = 0;
		for (int i = 0; i < coloumnsSize; i++) {
			if (listOfColoumns.get(i).getText().contains(coloumnName)) {
				j = i;
				break;
			}
		}
		return j;

	}


}