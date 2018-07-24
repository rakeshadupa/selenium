package appium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class UnreadMsgs extends AppiumBase {
	@Test
	public void testUnreadMsgs() throws Exception {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		int count = 0;
		while (true) {
			//click
			int unreadCount = driver.findElements(By.id("com.tvisha.troopmessenger:id/unreadMesgCount")).size();/// to
			/// get
																												/// unread
																												/// msgs
			System.out.println("unread count===" + unreadCount);

			List<AndroidElement> b = driver.findElements(By.id("com.tvisha.troopmessenger:id/userName"));
			for (int i = 0; i < b.size(); i++) {

				List<AndroidElement> a = driver.findElements(By.id("com.tvisha.troopmessenger:id/userName"));
				// System.out.println("first list=== " + a.get(i).getText() + "for index of " +
				// i);
				l1.add(a.get(i).getText());
				// System.out.println("list 1===========" + a.size());

				if (unreadCount != 0) {

					List<AndroidElement> v = driver.findElements(By.xpath(
							"//android.support.v7.widget.RecyclerView[@index='1']//android.widget.LinearLayout[@index="
									+ i
									+ "]//android.widget.RelativeLayout[@index='0']//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@resource-id='com.tvisha.troopmessenger:id/unreadMesgCount']"));

					System.out.println("size is " + v.size());

					if (v.size() == 1) {
						String unreadChatName = v.get(0).getText();
						count++;
						System.err.println("for index of " + i + "...." + a.get(i).getText() + "unread msg " + count);

					}
				}

			}
			swipeVertical(driver, 0.9, 0.1, 0.5, 1000);
			List<AndroidElement> b1 = driver.findElements(By.id("com.tvisha.troopmessenger:id/userName"));
			for (int j = 0; j < b1.size(); j++) {

				List<AndroidElement> a = driver.findElements(By.id("com.tvisha.troopmessenger:id/userName"));
				// System.out.println("second list== " + a.get(j).getText());
				l2.add(a.get(j).getText());
				// System.out.println("list 2===========" + a.size());

			}
			System.out.println("l1===" + l1);
			System.out.println("l2===" + l2);
			if (l1.equals(l2)) {
				System.out.println("going to break");
				break;
			} else {
				l1.clear();
				l2.clear();
			}
		}
	}

	public void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage,
			double anchorPercentage, int duration) throws Exception {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * finalPercentage);
		new TouchAction(driver).press(anchor, startPoint).waitAction(Duration.ofMillis(duration))
				.moveTo(anchor, endPoint).release().perform();
	}

}
