package twoemulators;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;


public class Book_Stylist_Customer implements Runnable {
WebDriver driver;
	
	
	@Override
	public void run() {
		
	install i=	new install("10D087A7-EDDF-4034-B98F-BFF13AE5FAD2", "4720","iPhone 6s","customer.app");
	try {
		driver=i.installApp();
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
	}

}
