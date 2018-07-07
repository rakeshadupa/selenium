package com.maven.sample;
import java.io.IOException;
import org.testng.annotations.Test;
public class Practice2 extends Practice3 {

	@Test
	private void vevo() throws InterruptedException, IOException {
		System.out.println("@Test-1");
	}
	@Test
	private void vsevo() throws InterruptedException, IOException {
		System.out.println("@Test-2");
	}
	
}