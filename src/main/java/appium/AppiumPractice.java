package appium;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.ScreenRecordingUploadOptions;

public class AppiumPractice extends AppiumBase
{

	
@Test
public void practice() throws InterruptedException
	{
	
	/*driver.openNotifications();
	//driver.sendSMS("9133559366", "hello this is appium");
	
	
		 driver.openNotifications();
		    List<AndroidElement> allnotifications=driver.findElements(By.id("android:id/title"));

		    for (WebElement webElement : allnotifications) {
		        System.out.println(webElement.getText());
		        if(webElement.getText().contains("something")){
		            System.out.println("Notification found");
		            break;
		        }
		    }*/

	//driver.startRecordingScreen();
	ScreenRecordingUploadOptions cr=new ScreenRecordingUploadOptions();
	cr.withRemotePath("");
	
	
//	driver.startRecordingScreen(new BaseStartScreenRecordingOptions<BaseStartScreenRecordingOptions<T>>().withUploadOptions(cr) {
//	})








	
	
	}
}
