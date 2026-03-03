package testScripts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecTest {
  @Test
  public void test() {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strTitle = (String) js.executeScript("return document.title");
		System.out.println(strTitle);
		WebElement inpName = (WebElement)js.executeScript("return document.getElementById('name')");
		inpName.sendKeys("TestUser");
		js.executeScript("window.scrollBy(100, document.body.scrollHeight)");


  }
}
