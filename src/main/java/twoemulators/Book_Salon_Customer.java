package twoemulators;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public class Book_Salon_Customer implements Runnable {
	WebDriver driver;
	@Override
	public void run() {
		
	install i=	new install("F17918E2-4AA7-427A-BCEE-86EB9CDA643F", "4720","iPhone 6s","customer.app");
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
