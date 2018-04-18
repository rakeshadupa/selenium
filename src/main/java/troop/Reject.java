package troop;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.maven.sample.SeleniumBase;

public class Reject extends SeleniumBase {
	@Test
	public void testReject() throws InterruptedException {
		driver.get("https://www.troopmessenger.com/");
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.findElement(By.name("email")).sendKeys("shailu.8716@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.id("bG9naW5CdG4")).click();
		driver.findElement(By.id("addNewUsersBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Suggested users']")).click();
		Thread.sleep(1000);

		int memberSize = driver.findElements(By.xpath("//div[@class='suggested-users-wrapper']/div")).size();
		System.out.println(memberSize);

		for (int i = 1; i <= memberSize; i++) {

			driver.findElement(By.xpath("//div[@class='suggested-users-wrapper']/div//div[@class='suggested-user-reject-btn']")).click();
			Thread.sleep(1000);

		}

}

}
