package com.maven.sample;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import extent_reports.ExtentReporterNG;

public class Practice2 {
@Test
	public void test()
	{
ExtentReporterNG.test.log(LogStatus.INFO, "this is the log status");

	}
}