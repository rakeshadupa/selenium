package appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Gmail {

	// AndroidDriver<AndroidElement> driver;
	public AndroidDriver<MobileElement> driver;

	@Test
	public void installapp() throws MalformedURLException, InterruptedException {
		String email = null;
		String password = null;
		File f = new File("src");
		File fr = new File(f, "Gmail.apk");
		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capa.setCapability("autoGrantPermissions", "true");
		capa.setCapability("waitForAppScript", "true");
		capa.setCapability(MobileCapabilityType.APP, fr.getAbsolutePath());
		capa.setCapability("unicodeKeyboard", true);
		capa.setCapability("resetKeyboard", true);
		capa.setCapability("noReset", "true");
		
		
		capa.setCapability("appPackage", "com.google.android.gm");
		
//		capa.setCapability("appActivity", "com.google.android.gm.setup.ComposeActivityGmail");
		capa.setCapability("appActivity", "com.google.android.gm.setup.AccountSetupFinalGmail");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capa);
//		System.exit(0);
		capa.setCapability("newCommandTimeout", 120);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("com.google.android.gm:id/account_setup_item")).click();
		Thread.sleep(10000);
		// driver.findElement(By.id("com.google.android.gm:id/account_setup_item")).click();
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(email);
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
		try {
			driver.findElement(By.xpath("//*[@text()=skip]")).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("no skip button to click");
		}
		driver.findElement(By.id("signinconsentNext")).click();
		driver.activateApp("com.google.android.gm");
		try {
		driver.findElement(By.xpath("//*[@text()='Next']")).click();
		driver.findElement(By.xpath("//*[@text()='Ok']")).click();
		}
		catch (NoSuchElementException e) {
			System.out.println("no next button after relaunch");
			// TODO: handle exception
		}
		
		driver.findElement(By.id("com.google.android.gm:id/compose_button")).click();
		

	}
}
