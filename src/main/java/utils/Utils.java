package utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
	// it clicks using javascript executor
	public static void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// it sendkeys using javascript executor
	public static void javascriptSendKeys(WebDriver driver, WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value=' " + data + " ';", element);
	}

	public static void makeElementFlash(WebDriver driver, WebElement element) throws InterruptedException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		for (int i = 1; i <= 10; i++) {
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			Thread.sleep(100);
			js.executeScript("arguments[0].style.border='3px solid white'", element);
			Thread.sleep(100);
		}
	}

	// this gives randomly generated email
	public static String randomEmail() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return "rakesh@" + saltStr + ".com";
	}

	// this gives randomly generated 10 digit mobile number
	public static String randomNumber() {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 9) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return "9" + saltStr;
	}

	public static String randomString() {
		String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static void selectDate2(WebDriver driver) {
		getYear1(driver);

	}

	private static int getYear1(WebDriver driver) {

		int a = Integer.parseInt(driver.findElement(By.xpath(selectMonthXpath)).getText().replaceAll("[^0-9]", ""));
		// System.out.println("Current year present "+a);

		return a;

	}

	// private static String nextYearButtonXpath = "//*[@title='Next Year']";
	// private static String previousYearButtonXpath = "//*[@title='Previous
	// Year']";
	// private static String monthsListXpath = "//span[contains(@class,'month')]";
	// private static String daysListXpath = "//td[contains(@class,'day')]";
	// private static String selectMonthXpath = "//th[@title='Select Month']";
	// private static String selectYearXpath = "//th[@title='Select Year']";

	private static String nextYearButtonXpath = "//div[contains(@class,'months')]//th[@class='next']";
	private static String previousYearButtonXpath = "//*[@title='Previous Year']";
	private static String monthsListXpath = "//span[contains(@class,'month')]";
	private static String daysListXpath = "//td[contains(@class,'day')]";
	private static String selectMonthXpath = "//th[@title='Select Month']";
	private static String selectYearXpath = "//th[@title='Select Year']";
	private static String clickTimePopUpXpath = "//*[@title='Select Time']";

	public static void selectDate(String DDMmmYYYY, WebDriver driver) {

		// ====================================================
		// date parameter should be in DD-MMM-YYYY format
		// ====================================================
		try {
			Thread.sleep(500);
			driver.findElement(By.xpath(selectMonthXpath)).click();
		} catch (Exception e) {
			System.out.println("calender opened with months");
		}

		String d[] = DDMmmYYYY.split("-");
		int inputDay = Integer.parseInt(d[0]);
		String inputMonth = d[1];
		int inputYear = Integer.parseInt(d[2]);
		// System.out.println("day"+inputDay);
		// System.out.println("month"+inputMonth);
		// System.out.println("year"+inputYear);

		if (inputYear < getYear(driver)) {
			while (inputYear < getYear(driver)) {
				System.err.println("clicking previous button");
				driver.findElement(By.xpath(previousYearButtonXpath)).click();

			}
		} else if (inputYear > getYear(driver)) {

			while (inputYear > getYear(driver)) {
				// System.err.println("clicking Next button");
				driver.findElement(By.xpath(nextYearButtonXpath)).click();

			}
		}
		List<WebElement> l = driver.findElements(By.xpath(monthsListXpath));
		for (WebElement webElement : l) {
			String su = webElement.getText();
			// System.out.println(su);
			if (inputMonth.equals(su)) {
				System.out.println(webElement.getText() + "clicked");
				webElement.click();

				break;
			}

		}

		List<WebElement> dayList = driver.findElements(By.xpath(daysListXpath));
		for (WebElement webElement : dayList) {
			String su = webElement.getText();
			// System.out.println(su);
			if (inputDay == Integer.parseInt(su)) {
				// System.out.println(webElement.getText()+"clicked");
				webElement.click();

				break;
			}

		}
	}

	public static int getYear(WebDriver driver) {

		int a = Integer.parseInt(driver.findElement(By.xpath(selectYearXpath)).getText());
		// System.out.println("Current year "+a);

		return a;

	}

	// ==========================================================================================================================================================================================
	public static void selectDateAndTime(String DDMmmYYYY, String HH_MM_AM, WebDriver driver)
			throws InterruptedException {
		String[] time = HH_MM_AM.split(":");
		int hour = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		String amOrPm = time[2];

		selectDate(DDMmmYYYY, driver);
		driver.findElement(By.xpath(clickTimePopUpXpath)).click();
		setHour(hour, driver);
		setMinute(minutes, driver);
		setAMPM(amOrPm, driver);

	}
	public static void selectDateAndTime24(String DDMmmYYYY, String HH_MM, WebDriver driver)
			throws InterruptedException {
		String[] time = HH_MM.split(":");
		int hour = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);

		selectDate(DDMmmYYYY, driver);
		driver.findElement(By.xpath(clickTimePopUpXpath)).click();
		setHour(hour, driver);
		setMinute(minutes, driver);

	}

	// ==========================================================================================================================================================================================
	private static void setHour(int givenHour, WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@title='Pick Hour']")).click();
		List<WebElement> hours = driver.findElements(By.xpath("//div[@class='timepicker-hours']//td"));

		for (WebElement webElement : hours) {
			if (Integer.parseInt(webElement.getText()) == givenHour) {
				webElement.click();
				break;

			}
		}
	}

	private static void setMinute(int givenMinute, WebDriver driver) throws InterruptedException {

		if (givenMinute % 5 == 0) {
			driver.findElement(By.xpath("//*[@title='Pick Minute']")).click();
			// List<WebElement>minutes=driver.findElements(By.xpath("//div[@class='timepicker-minutes']//td"));
			Thread.sleep(2000);
			List<WebElement> minutes = driver.findElements(By.xpath("//*[@data-action='selectMinute']"));
			Thread.sleep(2000);
			System.out.println("gooo" + minutes.get(5).getText() + "special*****************");
			for (WebElement ele : minutes) {
				System.out.println(ele.getText());
			}
			System.err.println("***************** " + minutes.size());
			for (WebElement webElement : minutes) {
				System.out.println(webElement.getText());
				System.out.println(Integer.parseInt(webElement.getText()));
				System.out.println(Integer.parseInt(webElement.getText()) == givenMinute);
				if (Integer.parseInt(webElement.getText()) == givenMinute) {
					webElement.click();
					break;

				}
			}

		} else {
			int currentMinute = Integer.parseInt(driver.findElement(By.xpath("//*[@title='Pick Minute']")).getText());

			while (givenMinute != currentMinute) {

				if (givenMinute > currentMinute) {
					driver.findElement(By.xpath("//*[@title='Increment Minute']")).click();

				} else if (givenMinute < currentMinute) {
					driver.findElement(By.xpath("//*[@title='Decrement Minute']")).click();

				}
				currentMinute = Integer.parseInt(driver.findElement(By.xpath("//*[@title='Pick Minute']")).getText());
			}
		}
	}

	private static void setAMPM(String givenPeroid, WebDriver driver)

	{
		WebElement period = driver.findElement(By.xpath("//*[@title='Toggle Period']"));
		String currentPeriod = period.getText();
		if (!givenPeroid.equalsIgnoreCase(currentPeriod)) {
			period.click();

		}

	}
}
