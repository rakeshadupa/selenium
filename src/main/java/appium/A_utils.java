package appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class A_utils {
	public static void  scroll(AndroidDriver<AndroidElement> driver) throws InterruptedException
	{
		Thread.sleep(3000);
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.46;
		int scrollEnd = screenHeightEnd.intValue();
		
//		TouchAction t = new TouchAction(driver);
//		t.press(0, scrollStart).perform();
//		t.moveTo(0,scrollEnd).release().perform();
		
	}
	
	public static String getToast(WebDriver driver)
	{
		WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		String text = toastView.getAttribute("name");
		System.err.println("toast   " + text);
		return text;

	}
	public static void clickPasteButton(AppiumDriver<MobileElement> driver, MobileElement ele) throws InterruptedException
	{
		TouchAction T = new TouchAction(driver);
		T.longPress(new LongPressOptions().withElement(ElementOption.element(ele)).withDuration(Duration.ofMillis(2000)))
				.release().perform();
		Thread.sleep(1000);

		T.tap(PointOption.point(ele.getLocation().x + 30, ele.getLocation().y - 30)).perform();
	}
}
