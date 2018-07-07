package javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {

	public static void makeElementFlash(WebDriver driver, WebElement element) throws InterruptedException {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		for (int i = 1; i <= 3; i++) {
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			Thread.sleep(200);
			js.executeScript("arguments[0].style.border='3px solid white'", element);
			Thread.sleep(200);
		}
	}

}
