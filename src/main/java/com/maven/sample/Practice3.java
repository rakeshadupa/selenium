package com.maven.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Ignore
public class Practice3 {

	public WebDriver driver;

	@Test(priority = 1)
	void a() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

}}