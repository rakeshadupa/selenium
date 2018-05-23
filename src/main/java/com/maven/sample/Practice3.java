package com.maven.sample;

import org.testng.annotations.Test;

public class Practice3 extends SeleniumBase {

	@Test
	public void demo() throws Exception {
		driver.get("https://stackoverflow.com/questions/11947832/how-to-click-an-element-in-selenium-webdriver-using-javascript");
	}

}
