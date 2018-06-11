package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
public class AppiumBase {
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void aTestBase() throws InterruptedException, MalformedURLException {
		File f = new File("src");
		//File f1 = new File(f, "troop.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
	    cap.setCapability("appPackage", "com.tvisha.troopmessenger"); 
	    cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

/*		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("mobile");
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("password");
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		Thread.sleep(40000);
		driver.findElementById("com.tvisha.troopmessenger:id/options").click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='1']").click();*/
//			TouchAction t=new TouchAction(driver);
//			System.out.println("try");
//			
//		t.tap(driver.findElementByXPath("//android.widget.LinearLayout[@index='1']")).perform();
//		
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='1']").click();
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='2']").click();
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='3']").click();
//		driver.findElementByXPath("//android.support.v7.app.ActionBar$Tab[@index='4']").click();

//		driver.findElementByXPath("//android.widget.TextView[text()='Password']").click();		
	//	driver.findElementByName("Password").click();
/*		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(1).click();	
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(2).click();	
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(2).click();	
		driver.findElementsByXPath("//android.widget.HorizontalScrollView[@index='0']//android.widget.TextView").get(3).click();	*/


	}

	
	

}
