package appium;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBase {
	AndroidDriver<AndroidElement> driver;

	// driver.findElementByAndroidUIAutomator(“new UiScrollable(new
	// UiSelector()).scrollIntoView(text(“Enter your element”))”);
	@BeforeTest
	public void aTestBase() throws Exception {
		File f = new File("src");
		File f1 = new File(f, "troop.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("appPackage", "com.tvisha.troopmessenger");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("9133559366");
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("recommend139");
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		Thread.sleep(40000);

	}
}
