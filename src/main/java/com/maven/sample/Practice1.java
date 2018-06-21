package com.maven.sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Practice1 extends SeleniumBase {
	

	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.troopcrm.com/");
		Thread.sleep(2000);
		driver.close();

	}
}
