package appium;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class Apractice extends AppiumBase {

	@Test
	private void testApractice() throws InterruptedException, IOException {
	
		System.out.println("==========+==========>"+driver.findElement(By.id("com.tvisha.mrmrsprovider:id/iv_avatar")).isDisplayed());
		
//		driver.findElement(By.xpath("//android.widget.TextView[text()='Ideaa  Numberr']")).click();
		System.exit(0);


		List<AndroidElement> element=driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Ideaa')]"));
		System.out.println(element.size());
		List<AndroidElement> z=driver.findElements(By.xpath("//android.widget.TextView[text(),'Ideaa')]"));
		System.out.println("z"+z.size());
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "up");
		
		scrollObject.put("element", ((RemoteWebElement) element.get(0)).getId());
		js.executeScript("mobile: scroll", scrollObject);
		System.exit(0);
		TouchActions t = new TouchActions(driver);
		
		try {
			// driver.findElement(By.id("com.tvisha.mrmrsprovider:id/rb_rate")).click();

			t.singleTap(driver.findElement(By.xpath("//android.widget.TextView[@text='Ideaa  Numberr']"))).perform();
		} catch (NoSuchElementException e) {
			try {
				t.click(driver.findElement(By.xpath("//android.widget.TextView[@text='Ideaa  Numberr']"))).perform();

				t = new TouchActions(driver);
				t.singleTap(driver.findElement(By.id("com.tvisha.mrmrsprovider:id/iv_avatar"))).perform();
			} catch (NoSuchElementException e1) {
				driver.findElement(By.xpath("//android.widget.TextView[@text='Ideaa  Numberr']")).click();

			}

		}

	}

}
