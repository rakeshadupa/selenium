package com.maven.sample;

import static org.testng.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Ignore
public class Practice3 {

	public static WebDriver driver;
	
	static void init()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}

	
	
}