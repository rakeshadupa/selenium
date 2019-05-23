package com.maven.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;		
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;		
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;		
import org.openqa.selenium.WebDriver;		
import org.testng.annotations.Test;

public class CokieNewTest extends SeleniumBase {

@Test
	public void rtes() throws InterruptedException {

		driver.get("http://192.168.2.150/development/mr_miss/public/admin");
		driver.findElement(By.id("bG9naW5Vc2VybmFtZQ")).sendKeys("admin@mrandms.com");
		driver.findElement(By.id("bG9naW5QYXNzd29yZA")).sendKeys("123456");
		driver.findElement(By.id("bG9naW5CdG4")).click();
		Thread.sleep(5000);
		File file = new File("Cookie.data");
		try { // Delete if any old file exists
			file.delete();
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferwrite = new BufferedWriter(fileWriter);
			for (Cookie cook : driver.manage().getCookies()) {
				String writeup = cook.getName() + ";" + cook.getValue() + ";" + cook.getDomain() + ";" + cook.getPath()
						+ "" + ";" + cook.getExpiry() + ";" + cook.isSecure();
				bufferwrite.write(writeup);
				System.out.println(writeup);
				bufferwrite.newLine();
			}
			bufferwrite.flush();
			bufferwrite.close();
			fileWriter.close();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
//	@Test
	public void wejfr()
	{
		try{
			File file = new File("Cookie.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while((strline=Buffreader.readLine())!=null){
			StringTokenizer token = new StringTokenizer(strline,";");
			while(token.hasMoreTokens()){
			String name = token.nextToken();String value = token.nextToken();
			String domain = token.nextToken();String path = token.nextToken();
			Date expiry = null;
			String val;
			if(!(val=token.nextToken()).equals("null")){
			expiry = new Date(val);
			}
			Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
			Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
			driver.manage().addCookie(ck); // This will add the stored cookie to our current session
			}
			}
			}catch(Exception ex){
			ex.printStackTrace();
			}
			driver.get("http://192.168.2.150/development/mr_miss/public/admin");
	}
}
