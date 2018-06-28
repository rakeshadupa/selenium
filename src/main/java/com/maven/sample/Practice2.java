package com.maven.sample;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.common.base.Strings;


public class Practice2 {

	

	@Test
	private void vevo() {
		String a=null;
		if (Strings.isNullOrEmpty(a)) {
			System.out.println("successs");
		}

	}

}