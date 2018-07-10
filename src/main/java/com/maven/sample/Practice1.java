package com.maven.sample;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Practice1 {

@Test	
public void testPro() {
	
	try {
		assertEquals(false, true);
		System.out.println("rakesh");
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	System.out.println("===========continue");
	
	}
}
