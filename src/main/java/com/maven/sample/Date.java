package com.maven.sample;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Date extends SeleniumBase {
	 int targetDay = 4, targetMonth = 6, targetYear = 1993;

	 int currenttDate = 0, currenttMonth = 0, currenttYear = 0;

	 int jumMonthBy = 0;

	 boolean increment = true;

	public  void getCurrentDayMonth() {

		Calendar cal = Calendar.getInstance();
		currenttDate = cal.get(Calendar.DAY_OF_MONTH);
		currenttMonth = cal.get(Calendar.MONTH) + 1;
		currenttYear = cal.get(Calendar.YEAR);
	}

	public  void getTargetDayMonthYear(String dateString) {
		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");

		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(lastIndex + 1, dateString.length());
		targetYear = Integer.parseInt(year);

	}

	public  void calculateToHowManyMonthToJump() {

		if ((targetMonth - currenttMonth) > 0) {
			jumMonthBy = targetMonth - currenttMonth;

		} else {
			jumMonthBy = currenttMonth - targetMonth;
			increment = false;
		}
	}

	@Test
	public void def() throws InterruptedException {
		// TODO Auto-generated method stub
		String dateToSet = "01/01/2017";

		getCurrentDayMonth();
		System.out.println(currenttDate);
		System.out.println(currenttMonth);
		System.out.println(currenttYear);

		getTargetDayMonthYear(dateToSet);
		System.out.println(targetDay);
		System.out.println(targetMonth);
		System.out.println(targetYear);

		calculateToHowManyMonthToJump();
		System.out.println(jumMonthBy);
		System.out.println(increment);

		driver.navigate().to("https://jqueryui.com/resources/demos/datepicker/default.html");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys(dateToSet);

		/*for (int i = 0; i < jumMonthBy; i++) {
			if (increment) {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
			} else {
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span")).click();
			}
			Thread.sleep(1000);

		}*/

		//driver.findElement(By.linkText(Integer.toString(targetDay))).click();
	}
	
	
	
	//==========================================================================================================//
	//troopcrm Date picker
	//==========================================================================================================//
	@Test
	public void demo() throws InterruptedException

	{
		String desiredDate = "25-JUNE-2018";// Enter the date exactly in this format
		String[] sDate = desiredDate.split("-");
		String givenDay = sDate[0];
		String givenMonth = sDate[1];
		int givenYear = Integer.parseInt(sDate[2]);
		driver.get("https://www.troopcrm.com/");
		driver.findElement(By.id("username")).sendKeys("9133559366");
		driver.findElement(By.id("password")).sendKeys("recommend139");
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.xpath("//span[text()='TASK']")).click();
		driver.findElement(By.id("open-add-task-bar")).click();
		utils.UtilityClass.exWaitForVisible(driver, 10, driver.findElement(By.id("task_dateOfDelivery")));
		driver.findElement(By.id("task_dateOfDelivery")).click();

		while (givenYear > getYear()) {
			utils.UtilityClass.exWaitForVisible(driver, 5, driver.findElements(By.xpath("//th[@class='next']")).get(0));

		}
		if (!getMonth().equalsIgnoreCase(givenMonth)) {

			driver.findElements(By.xpath("//th[@class='datepicker-switch']")).get(0).click();
			List<WebElement> l = driver.findElements(By.xpath("//span[contains(@class,'month')]"));

			for (WebElement webElement : l) {
				String su = webElement.getText().toUpperCase();
				if (givenMonth.contains(su)) {
					webElement.click();
					break;
				}

			}

		}
		List<WebElement> dayList = driver.findElements(By.xpath("//td[@class='day']"));
		for (WebElement webElement : dayList) {
			String su = webElement.getText();
			System.out.println(su);
			if (givenDay.equals(su)) {
				webElement.click();
				break;		
			}

		}

	}

	public int getYear() {
		String yearText = driver.findElements(By.xpath("//th[@class='datepicker-switch']")).get(0).getText();
		int currentYear = Integer.parseInt(yearText.replaceAll("[^0-9]", ""));
		System.out.println("current yr==>  " + currentYear);
		return currentYear;
	}

	public String getMonth() {

		String yearText = driver.findElements(By.xpath("//th[@class='datepicker-switch']")).get(0).getText();
		String currentMonth = yearText.replaceAll("[^a-zA-Z]+", "");
		System.out.println("current month==>  " + currentMonth);
		return currentMonth;

	}
}
