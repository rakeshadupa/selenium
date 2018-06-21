package com.maven.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Practice3 {

	
	WebDriver driver;
	public Practice3(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
