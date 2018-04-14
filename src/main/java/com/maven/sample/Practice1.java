package com.maven.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Practice1 extends SeleniumBase {

@Test
public void test() {
driver.get("https://www.freecrm.com/index.html");
List<WebElement> l=driver.findElements(By.tagName("a"));
//driver.navigate().refresh();
for(WebElement i: l)
{
System.out.println(i.getText());





}

}
}