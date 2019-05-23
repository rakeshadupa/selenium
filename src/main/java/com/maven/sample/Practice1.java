package com.maven.sample;

import org.testng.annotations.Test;

public class Practice1 {
	@Test
	void test() {

		String[][] a = new String[2][3];
		
		
		a[0][0]="a";
		a[0][1]="b";
		a[0][2]="b";
		
		a[1][0]="a";
		a[1][1]="a";
		a[1][2]="b";
		System.out.println(a[0].length);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.println(a[i][j]);
			}
		}

	}
}
