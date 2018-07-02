package com.maven.sample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Toast {
	public static String Verify(WebDriver driver) {

		String result = null;
		File scrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		ITesseract instance = new Tesseract();
		System.out.println("entered===>");
		instance.setDatapath("/home/rakesh/Documents/eclipseworkspace/Tess4J/tessdata");
		instance.setLanguage("eng");
		try {
			result = instance.doOCR(scrFile);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	
	public static String VerifyForScreenshot(WebDriver driver,BufferedImage screenshot) {

		String result = null;
		ITesseract instance = new Tesseract();
		instance.setDatapath("/home/rakesh/Documents/eclipseworkspace/Tess4J/tessdata");
		instance.setLanguage("eng");
		try {
			result = instance.doOCR(screenshot);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

}