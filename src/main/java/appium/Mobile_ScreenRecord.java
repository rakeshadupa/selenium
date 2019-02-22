package appium;

import org.testng.annotations.Test;

public class Mobile_ScreenRecord extends AppiumBase {

	
	@Test
	void testApp() throws InterruptedException
	{
		driver.startRecordingScreen();
		Thread.sleep(5000);
		String a=driver.stopRecordingScreen();
		System.err.println(a);
		
	}
}
