package com.maven.sample;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import extent_reports.ScreenRecorder;

public class Practice1 {

	@Test
	public void testPro() throws InterruptedException {

		ScreenRecorder a = new ScreenRecorder();
		a.startRecording("raki");
		Thread.sleep(3000);
		a.stopRecording();

	}
}
