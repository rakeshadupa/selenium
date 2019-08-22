package com.maven.sample;

import java.io.File;
import java.util.Map;

import org.testng.annotations.Test;

public class Practice1 {
	@Test
	public void testt() {

		File f=new File("./src/databaseSheet.xlsx");
			System.out.println(f.exists());
		

	}
}
