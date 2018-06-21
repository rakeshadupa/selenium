package com.maven.sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Practice2 extends SeleniumBase {


	@Test
	private void demo() throws InterruptedException {
		driver.get("http://testng.org/doc/documentation-main.html");
		Thread.sleep(2000);
		driver.close();
	}
}