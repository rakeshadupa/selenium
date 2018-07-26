package com.maven.sample;

import java.awt.AWTException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice1 {
	boolean a = true;

	@Test
	public void run() throws InterruptedException, AWTException {

		SoftAssert s = new SoftAssert();
		s.assertTrue(true);
		s.assertTrue(a);
	
		try {
		s.assertAll();
		}
		catch(AssertionError e)
		{
		System.err.println("extent  fail log here"); 
		}

	}
}

