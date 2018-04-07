package com.maven.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;


import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practice extends SeleniumBase{
@Test
	 public void testPractice() throws InterruptedException
	 {
		 driver.get("http://192.168.2.60/ebadi_web/public/");
//		 driver.findElement(By.partialLinkText("sign")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'sign')]")).click();
		 driver.findElement(By.id("username")).sendKeys("rakesh");
		 driver.findElement(By.id("email")).sendKeys("rakeshraki@gmail.com");
		 driver.findElement(By.id("pass")).sendKeys("1234567");
		 Select s=new Select(driver.findElement(By.id("state")));
		 s.selectByIndex(1);
		 driver.findElement(By.id("login_btn")).click();
		 Thread.sleep(3000);
		 
	 }
		


}
