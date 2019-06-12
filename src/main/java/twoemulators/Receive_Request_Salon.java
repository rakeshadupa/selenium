package twoemulators;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Receive_Request_Salon implements Runnable{
	IOSDriver<MobileElement> driver;
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("checking condition");
		if (true) {
			
		System.err.println("installing provider app--------");
		install i=	new install("C0E4BD27-F465-4105-A40B-2DBECF66FD34", "4723","iPhone 6","provider.app");
		try {
			driver=i.installApp();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		break;
		}
		}
		while(true)
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Waiting to receive booking as a salon");
			if (true) {
				try{
				driver.findElements(By.xpath("//XCUIElementTypeButton")).get(1).click();
				}
				catch (NoSuchSessionException e) {
					driver.findElements(By.xpath("//XCUIElementTypeButton")).get(1).click();
				}
				break;
			}
		
		}
		System.out.println("do now");
		System.out.println("do now");
		System.out.println("do now");
		System.out.println("do now");
		System.out.println("do now");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		}
	
}
