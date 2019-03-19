package com.maven.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Goibibo extends SeleniumBase_old {
	boolean status=true;
	@Test
	public void testGoibibo() throws InterruptedException, AWTException {
		driver.get("https://www.goibibo.com/flights");
		driver.findElement(By.id("gi_roundtrip_label")).click();
		WebElement fromCity = driver.findElement(By.id("gosuggest_inputSrc"));
		fromCity.sendKeys("Bangalore");
		Thread.sleep(1000);
		fromCity.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		WebElement toCity = driver.findElement(By.id("gosuggest_inputDest"));
		toCity.sendKeys("mumbai");
		Thread.sleep(1000);
		toCity.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		Thread.sleep(3000);
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//*[@class='close']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date today = calendar.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd yyyy");
		String departure = formatter.format(today);
		System.out.println("calender" + departure);

		calendar.add(Calendar.DAY_OF_YEAR, 2);

		Date tomorrow = calendar.getTime();
		String arrival = formatter.format(tomorrow);

		System.out.println("calender" + arrival);

		List<WebElement> dates = driver.findElements(By.xpath("//*[@aria-disabled='false']"));
		for (WebElement webElement : dates) {
			String dayGetText = webElement.getAttribute("aria-label");
			System.out.println(dayGetText);
			if (dayGetText.equals(departure)) {
				System.err.println(dayGetText);
				Actions a = new Actions(driver);
				// a.click(webElement);
				webElement.click();
				break;

			}
		}
		dates = driver.findElements(By.xpath("//*[@aria-disabled='false']"));
		for (WebElement webElement : dates) {
			String dayGetText = webElement.getAttribute("aria-label");
			System.out.println(dayGetText);

			if (dayGetText.equals(arrival)) {
				Actions a = new Actions(driver);
				// a.click(webElement);
				webElement.click();
				break;
			}
		}
		driver.findElement(By.id("gi_search_btn")).click();

		/*
		 * WebElement element =
		 * 
		 * driver.findElement(By.id("footer"));
		 * 
		 * JavascriptExecutor js = ((JavascriptExecutor) driver);
		 * js.executeScript("arguments[0].scrollIntoView();", element);
		 */
		
		reUse();
		status=true;
		

		WebElement viewAll = driver.findElement(By.id("showAllFlights"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", viewAll);
		reUse();
		List<WebElement> totalFlights = driver.findElements(By.xpath(
				"//*[@id='onwFltContainer']//*[@class='control__indicator']//..//../../div[1]//span[contains(@id,'o_')]"));

		System.out.println(totalFlights.size() + "  ->departure flights");
		int departSmallest = Integer.parseInt(totalFlights.get(0).getText().replaceAll("[^0-9]", ""));
		System.out.println(getSmallNumber(totalFlights, departSmallest )+"departure low price");
		
		List<WebElement> deparFlights=driver.findElements(By.xpath("//*[@id='retFltContainer']//*[@class='control__indicator']//..//../../div[1]//span[contains(@id,'r_')]"));
		int arrivalSmallest = Integer.parseInt(deparFlights.get(0).getText().replaceAll("[^0-9]", ""));
		System.out.println("arrival flights "+deparFlights.size());
		System.out.println(getSmallNumber(deparFlights, arrivalSmallest)+"  arrival low price");
		
		

	}
	public int getSmallNumber(List<WebElement> list,int smallest)
	{
		for (WebElement webElement : list) {

			int actualPrice = Integer.parseInt(webElement.getText().replaceAll("[^0-9]", ""));
		//	System.out.println(actualPrice);
			if (actualPrice < smallest) {
				smallest = Integer.parseInt(webElement.getText().replaceAll("[^0-9]", ""));

			}
		}
		return smallest;
	}

	public void reUse() throws AWTException, InterruptedException {
		
		List<WebElement> rates = driver.findElements(By.xpath(
				"//*[@id='onwFltContainer']//*[@class='control__indicator']//..//../../div[1]//span[contains(@id,'o_')]"));
		System.out.println(rates.size());

		// System.out.println("initial price" + smallest);

		List<WebElement> ratesAfterDown;

		clickPageDown(2);
		ratesAfterDown = driver.findElements(By.xpath(
				"//*[@id='onwFltContainer']//*[@class='control__indicator']//..//../../div[1]//span[contains(@id,'o_')]"));
		System.out.println("Rates before" + rates.size());
		System.out.println("Rates after" + ratesAfterDown.size());
		while (rates.size() != ratesAfterDown.size()) {
			clickPageDown(2);
			System.err.println("Entered in while");

			// Thread.sleep(2000);
			ratesAfterDown = rates;
			rates = driver.findElements(By.xpath(
					"//*[@id='onwFltContainer']//*[@class='control__indicator']//..//../../div[1]//span[contains(@id,'o_')]"));
			System.out.println("old" + ratesAfterDown.size());
			System.out.println("new" + rates.size());
		}
		clickPageDown(2);
		
		if(rates.size() == ratesAfterDown.size())
		{
			if (status)
			{
				status=false;
				System.err.println("First time");
			reUse();
			
			}
		}
		
	}

	public void clickPageDown(int i) throws AWTException, InterruptedException

	{
		int j = 1;

		while (j <= i) {

			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			j++;
			

		}
		Thread.sleep(2000);
	}

}
