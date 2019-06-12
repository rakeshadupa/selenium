package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumPractice  
{
@Test
public void testt() throws MalformedURLException
{
	AndroidDriver<MobileElement> driver;

	File f = new File("src");
	File f1 = new File(f, "provider.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
//	cap.setCapability(MobileCapabilityType.APP, "D:\\Rakesh\\Documents\\eclipseworkspace\\selenium_scripts\\Version_Project\\src\\provider.apk");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
	cap.setCapability("autoGrantPermissions", true);
	cap.setCapability("unicodeKeyboard", true);
	cap.setCapability("resetKeyboard", true);
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	cap.setCapability("appPackage", "com.tvisha.mrmrsprovider");
	cap.setCapability("appActivity", "com.tvisha.mrmrsprovider.ui.registration.common.SplashActivity");

	driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.findElement(By.id("com.tvisha.mrmrsprovider:id/tv_stylist")).click();
//	driver.findElement(By.id("com.tvisha.mrmrsprovider:id/tv_skip")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@text='Stylist']")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@text='Skip']")).click();
	MobileElement ele = driver.findElement(By.id("com.tvisha.mrmrsprovider:id/et_phone"));
	ele.sendKeys("123456789");
	System.exit(0);
}
}
