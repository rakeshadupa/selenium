package appium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;

public class AppiumPractice extends AppiumBase {

	
@Test
public void practice()
	{
	
	driver.openNotifications();
	
		 driver.openNotifications();
		    List<AndroidElement> allnotifications=driver.findElements(By.id("android:id/title"));

		    for (WebElement webElement : allnotifications) {
		        System.out.println(webElement.getText());
		        if(webElement.getText().contains("something")){
		            System.out.println("Notification found");
		            break;
		        }
		    }
	}
}
