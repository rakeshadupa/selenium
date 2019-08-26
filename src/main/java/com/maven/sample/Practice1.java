package com.maven.sample;

import java.io.File;

public class Practice1 {
	public static int main(String[] args) {

		try {
			System.out.println("try");
			throw new Exception();

		} catch (Exception e) {
			System.out.println("catch");
			File f = new File("");
			return 1;

		} finally {
			System.out.println("outside");
		}

	}
}
