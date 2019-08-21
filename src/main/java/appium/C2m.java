package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class C2m {

	

@Test
public void testt() throws MalformedURLException
{
	AndroidDriver<MobileElement> driver;

	File f = new File("src");
	File f1 = new File(f, "c2m.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
//	cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
	cap.setCapability("autoGrantPermissions", true);
	cap.setCapability("noReset", true);
	cap.setCapability("unicodeKeyboard", true);
	cap.setCapability("resetKeyboard", true);
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	cap.setCapability("appPackage", "com.tvisha.click2magic");
	cap.setCapability("appActivity", "com.tvisha.click2magic.ui.HomeActivity");

	driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
//	driver.findElement(By.id("com.tvisha.click2magic:id/item")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@text='Majili']/../../..")).click();

}

}
