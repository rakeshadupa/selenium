package com.maven.sample;

import static org.testng.Assert.assertEquals;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice2  {
	public static final String USERNAME = "rakesh592";
	public static final String AUTOMATE_KEY = "rFzeoSJWd12A763K5G1Y";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Parameters(value = { "browser", "version", "platform" })
	@Test
	public void setUp(String browser, String version, String platform) throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platform", platform);
		capability.setCapability("browserName", browser);
		capability.setCapability("browserVersion", version);
		capability.setCapability("project", "P1");
		capability.setCapability("build", "1.0");
		capability.setCapability("browserstack.console", "errors");
		capability.setCapability("browserstack.debug", true);
		WebDriver driver = new RemoteWebDriver(new URL(URL), capability);
		driver.get("https://www.troopcrm.com/");
		assertEquals(driver.getTitle(), "Troop CRMv");
		driver.quit();
	}
}