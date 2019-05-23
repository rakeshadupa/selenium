package com.maven.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;		
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.http.NameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;		
import org.openqa.selenium.WebDriver;		
import org.testng.annotations.Test;

public class CokieTest extends SeleniumBase {

	
	void testt() {
		driver.get("http://192.168.2.150/development/mr_miss/public/admin");
		driver.findElement(By.id("bG9naW5Vc2VybmFtZQ")).sendKeys("admin@mrandms.com");
		driver.findElement(By.id("bG9naW5QYXNzd29yZA")).sendKeys("123456");
		driver.findElement(By.id("bG9naW5CdG4")).click();

		File file = new File("Cookies.data");
		try {
			// Delete old file if exists
			file.delete();
			file.createNewFile();
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);
			// loop for getting the cookie information

			// loop for getting the cookie information
			for (Cookie ck : driver.manage().getCookies()) {
				Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwrite.newLine();
			}
			Bwrite.close();
			fileWrite.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Test
	public void loginThroughCookie() {
	
	driver.get("http://192.168.2.150/development/mr_miss/public/countries");
	
	
	
	}
}
