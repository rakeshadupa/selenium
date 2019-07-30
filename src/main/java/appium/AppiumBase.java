package appium;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumBase {
	AndroidDriver<AndroidElement> driver;



	@Test
	public void aTestBase() throws Exception {

		File f = new File("src");
		File f1 = new File(f, "provider.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		// cap.setCapability(MobileCapabilityType.UDID, "emulator-5556");
		 cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);

//		cap.setCapability("fullReset", false);
		// cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "240");

		cap.setCapability("appPackage", "com.tvisha.mrmrsprovider");
//		cap.setCapability("appActivity", "com.tvisha.mrandmrs.screens.registration.RegMobileActivity");
		// cap.setCapability("appActivity",
		// "com.tvisha.troopmessenger.activity.login.login.LoginActivity");
		cap.setCapability("appActivity", "com.tvisha.mrmrsprovider.ui.registration.common.SplashActivity");
		


		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("com.tvisha.mrmrsprovider:id/tv_stylist")).click();
		driver.findElement(By.id("com.tvisha.mrmrsprovider:id/tv_skip")).click();
		AndroidElement ele = driver.findElement(By.id("com.tvisha.mrmrsprovider:id/et_phone"));

		TouchAction T = new TouchAction(driver);
		T.longPress(new LongPressOptions().withElement(ElementOption.element(ele)).withDuration(Duration.ofMillis(2000)))
				.release().perform();
		Thread.sleep(2000);

		T.tap(PointOption.point(ele.getLocation().x + 30, ele.getLocation().y - 30)).perform();
		
		TouchActions t=new TouchActions(driver);
		t.flick(ele, 20, 30, 20);
		
		  WebElement banner = driver.findElement(By.xpath(""));
		    Point bannerPoint = banner.getLocation();
		    // Get size of device screen
		    Dimension screenSize = driver.manage().window().getSize();
		    // Get start and end coordinates for horizontal swipe
		    int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
		    int endX = 0;

		    TouchAction action = new TouchAction(driver);
		    action
		            .press(PointOption.point(startX, bannerPoint.getY()))
		            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		            .moveTo(PointOption.point(endX, bannerPoint.getY()))
		            .release();
		    driver.performTouchAction(action);


		// Thread.sleep(5000);
		// driver.setClipboardText("123456789");
		// AndroidElement
		// ele=driver.findElementById("com.tvisha.troopmessenger:id/userId");
		// Actions a=new Actions(driver);
		// a.clickAndHold(ele).perform();

		// driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("9133559366");
		// driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("recommend139");
		// driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		// Thread.sleep(40000);
		// System.out.println("Current activity==" + driver.currentActivity());
		// //
		// driver.findElement(By.id("com.tvisha.troopmessenger:id/forgotPassword")).click();
		// // System.err.println("clicked==============");
		// // Thread.sleep(3000);
		// // driver.resetApp();
		// // driver.closeApp();
		// // driver.findElement(By.id("com.tvisha.troopmessenger:id/send")).click();
		// Thread.sleep(3000);
		// driver.findElementByXPath("//android.widget.TextView[@text='SUBMIT']").click();
		// WebElement toastView =
		// driver.findElement(By.xpath("//android.widget.Toast[1]"));
		// String toast=toastView.getAttribute("name");
		// System.out.println(toast+"============");

		// Thread.sleep(50000);
		// try {
		// driver.findElementsById("com.tvisha.troopmessenger:id/item").get(0).click();
		// } catch (Exception e) {
		// driver.findElementsById("com.tvisha.troopmessenger:id/item").get(0).click();
		// }
		// Thread.sleep(5000);
		// System.err.println("Go ahead===========");
		// Thread.sleep(15000);
		// int msgSize =
		// driver.findElementsById("com.tvisha.troopmessenger:id/msgSentStatus").size();
		// WebElement msgStatus =
		// driver.findElementsById("com.tvisha.troopmessenger:id/msgSentStatus").get(msgSize
		// - 1);
		//
		// File a = Element_Screenshot.testElement_Screenshot(driver, msgStatus);
		//

		// SikuliUtils.compareImageInSikuli("/home/rakesh/Documents/Bug
		// reports/Mr&Mrs/test.png", a.getAbsolutePath());
		

	}

}
