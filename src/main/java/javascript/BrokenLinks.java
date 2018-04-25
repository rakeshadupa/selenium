package javascript;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks {

	public static void testLinks(WebDriver driver, String url) throws IOException {
		driver.get(url);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activeLinks = new ArrayList<>();
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getAttribute("href") != null && links.get(i).getAttribute("href").startsWith("http")) {
				activeLinks.add(links.get(i));
				String link = links.get(i).getAttribute("href");
				URL u = new URL(link);

				HttpURLConnection connection = (HttpURLConnection) u.openConnection(); //
				connection.connect();
				if (connection.getResponseCode() != 200) {
					if (connection.getResponseCode() == 404) {
						System.err.println(
								connection.getResponseCode() + "  " + connection.getResponseMessage() + "    " + link);

					} else {
						System.out.println(
								connection.getResponseCode() + "  " + connection.getResponseMessage() + "    " + link);
					}
				}

			}
		}
		System.out.println("total links are >>  " + links.size());

		System.out.println("active links are" + activeLinks.size());
	}

}
