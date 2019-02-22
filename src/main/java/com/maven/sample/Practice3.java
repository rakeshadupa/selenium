package com.maven.sample;

import static org.testng.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//@Ignore
public class Practice3 {

	@Test
	void testt() {
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("sdf", "");
		try {
		sa.assertAll();
		}
		catch (AssertionError e) {
			System.err.println("in catch");

			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));

			String a = sw.toString().split("at")[0].trim();
			System.out.println(a);


		
		
		}
		
		
		
		System.exit(0);

		try {
			
		} catch (AssertionError e) {

			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));

			String a = sw.toString().split("at")[0].trim();

		}
	}

}