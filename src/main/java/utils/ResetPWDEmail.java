package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.maven.sample.SeleniumBase;

public class ResetPWDEmail extends SeleniumBase {
	String email = "trueconnect.matrimony@gmail.com";

	@Test
	public void test() throws InterruptedException {
		driver.get("http://192.168.2.60/true_connect_web/public/");
		driver.findElement(By.id("forgotPasswordLink")).click();
		driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys(email);
		driver.findElement(By.id("Zm9yZ290c3VibWl0")).click();
		driver.findElement(By.xpath("//input[@placeholder='email']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys(getOtpFromEmail());

	}

	public String getOtpFromEmail() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get(
				"https://accounts.google.com/signin/v2/sl/pwd?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&followup=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("trueconnect123");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//a[@role='button']")).click();
		driver.findElement(By.id("ogbkddg:6")).click();

		WebElement element = driver.findElements(By.xpath("//tr[contains(@class,'zA')]")).get(0);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		String linktext = driver.findElement(By.xpath("//a[text()='Click here to Verify']")).getText();
		driver.close();
		return linktext;
	}
}
