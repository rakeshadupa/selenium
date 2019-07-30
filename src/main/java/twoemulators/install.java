package twoemulators;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class install {
	
	String udid;
	String port;
	String deviceName;
	String appName;
	public install(String udid,String port,String deviceName,String appName)
	{
		this.port=port;
		this.udid=udid;
		this.deviceName=deviceName;
		this.appName=appName;
	}

	IOSDriver<MobileElement> driver;
	public IOSDriver<MobileElement>  installApp() throws MalformedURLException
	{
File dir = new File(System.getProperty("user.dir")+"/src/");
		
		
		File app = new File(dir, appName);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0 (15A372)");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.UDID,udid);
		capabilities.setCapability("autoLaunch", true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "120");
		capabilities.setCapability("useNewWDA", true);
		capabilities.setCapability("automationName", "XCUITest");
	//	capabilities.setCapability("showIOSLog", true);
		driver = new IOSDriver(new URL("http://0.0.0.0:"+port+"/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
