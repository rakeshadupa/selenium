package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;

import com.maven.sample.SeleniumBase_old;

public class Gmail_Inbox extends SeleniumBase_old {

	public void deleteInbox(String email, String password, int tabIndex) throws InterruptedException {
		driver.get(
				"https://accounts.google.com/signin/v2/sl/pwd?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&followup=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//a[@role='button']")).click();
		driver.findElement(By.id("ogbkddg:6")).click();
		driver.findElements(By.xpath("//div[@class='aKw']")).get(tabIndex).click();
		for (int i = 0; i < 59; i++) {

			try {
				driver.findElement(By.xpath("//div[@role='presentation']")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@role='checkbox']")).click();
			}
			Thread.sleep(2000);
			try {
				driver.findElement(By.xpath("//div[contains(@class,'ar9')]")).click();
			} catch (ElementNotInteractableException e) {
				Thread.sleep(2000);

				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();",
						driver.findElement(By.xpath("//div[@class='ar9 T-I-J3 J-J5-Ji']")));

			}
			Thread.sleep(2000);

		}
	}
}
