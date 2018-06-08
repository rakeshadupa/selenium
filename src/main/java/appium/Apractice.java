package appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Apractice extends AppiumBase {
	@Test
	private void testApractice() throws InterruptedException {
		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("rakesh.adupa@tvisha.in");
		//driver.findElementByXPath("//android.widget.TextView[@text='E-Mail/Mobile']").sendKeys("sireesha.k@tvisha.in");
		//driver.findElementByXPath("//android.widget.EditText[@text='E-Mail/Mobile']").sendKeys("sireesha.k@tvisha.in");
		String pwd="";
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys(pwd);
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();

		//List<AndroidElement> lst=driver.findElementsByClassName("android.widget.RelativeLayout");
		//AndroidElement l=(AndroidElement) driver.findElementsByXPath("//*[@class='android.widget.RelativeLayout'][2]");
		//l.click();
		Thread.sleep(40000);
		driver.findElementById("com.tvisha.troopmessenger:id/actionSearch").click();

	}

}
