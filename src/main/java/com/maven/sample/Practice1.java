package com.maven.sample;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Practice1   {
	// @Test
	public  String randomNumber() {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 9) {
			System.out.println(salt.length());
			System.out.println(rnd.nextFloat());
			System.out.println(SALTCHARS.length());
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
//			int index = rnd.nextInt() * SALTCHARS.length();
			
			salt.append(SALTCHARS.charAt(index));
			System.out.println(salt);
		}
		String saltStr = salt.toString();
		return "9" + saltStr;
	}
	
	@Test
	private void rakesh() {
		

		System.out.println(randomNumber());
		
	}
}
