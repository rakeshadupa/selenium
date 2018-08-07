package com.maven.sample;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Practice1 {

	private void login(String name, String password) {

		System.out.println(name);
		System.out.println(password);

	}

	@Test
	public void executeLogin() {

		
		login(randomEmail(), "12356");
		
	}

	
	
	public static String randomEmail() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "@test.in";
	}
}
