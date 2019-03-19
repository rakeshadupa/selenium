package utils;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.maven.sample.SeleniumBase_old;

public class PizzaHut extends SeleniumBase_old {
	Select s;

	@Test
	public void demo() throws InvalidFormatException, IOException, InterruptedException {
		driver.get("https://www.pizzahut.co.in/customer-feedback.php");
		driver.findElement(By.xpath("//h4[text()='Dine in Feedback']")).click();
		driver.findElements(By.xpath("//input[@type='radio']")).get(1).click();
		s = new Select(driver.findElement(By.id("city_id")));
		s.selectByVisibleText("Hyderabad");
		s = new Select(driver.findElement(By.id("storeId")));
		s.selectByVisibleText("Madhapur");
		driver.findElement(By.name("next")).click();

		/*driver.findElement(By.name("name")).sendKeys("rakesh");
		s = new Select(driver.findElement(By.id("typeselector")));
		s.selectByVisibleText("Male");
		driver.findElement(By.name("email")).sendKeys("rakesh@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		s = new Select(driver.findElement(By.id("preferred_time")));
		s.selectByVisibleText("11-3 AM");
		driver.findElement(By.id("address")).sendKeys("address");*/
		
		
		
		driver.findElement(By.name("date_of_visit")).click();
		driver.findElement(By.xpath("//a[@title='Prev']")).click();
		driver.findElement(By.linkText("30")).click();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	driver.findElement(By.name("your_feedback")).sendKeys("feedback");
		Thread.sleep(500);
		driver.findElements(By.name("how_often_u_visit")).get(0).click();
		driver.findElement(By.name("image1")).sendKeys("/home/rakesh/Downloads/download.jpeg");
		driver.findElement(By.name("image2")).sendKeys("/home/rakesh/Downloads/download.png");
		driver.findElements(By.name("res_clean")).get(0).click();
		driver.findElements(By.name("service_hospitable")).get(0).click();
		driver.findElements(By.name("receive_wat_ordered")).get(0).click();
		driver.findElements(By.name("res_maintained")).get(0).click();
		driver.findElements(By.name("food_liking")).get(0).click();
		driver.findElements(By.name("serve_speedly")).get(0).click();
		driver.findElements(By.name("got_value_for_money")).get(0).click();
		driver.findElements(By.name("will_visit_pizzahut")).get(0).click();

		WebElement f = driver.findElement(By.name("math_captcha"));
		String sum = driver.findElements(By.xpath("//font")).get(0).getText();
		System.out.println(sum);
		String[] data = sum.split("\\s");
		System.out.println("array" + data.length);
		String opr = data[1];
		System.out.println(opr);

		String numberOnly = sum.replaceAll("[^0-9]", "");
		System.out.println(numberOnly);

		int first = Integer.parseInt(data[0]);
		int second = Integer.parseInt(data[2]);

		switch (opr) {
		case "+":
			int ans = first + second;
			f.sendKeys(Integer.toString(ans));

			break;
		case "-":
			int ans1 = first - second;
			f.sendKeys(Integer.toString(ans1));

			break;
		case "×":
			int ans2 = first * second;
			f.sendKeys(Integer.toString(ans2));

			break;
		case "÷":
			int ans3 = first / second;
			f.sendKeys(Integer.toString(ans3));

			break;

		default:
			System.out.println("error========");
			break;
		}
*/
	}
}
