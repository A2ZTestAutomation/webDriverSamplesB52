package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpWaitTest {

	@Test
	public void waitTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("http://uitestingplayground.com/ajax");
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(18));
		driver.findElement(By.id("ajaxButton")).click();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div#content"))));
		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(
						By.cssSelector("div#content")), "Data loaded with AJAX get request."));
		
		String strTxt = driver.findElement(By.cssSelector("div#content")).getText();
		Assert.assertEquals(strTxt, "Data loaded with AJAX get request.");
		System.out.println(strTxt);
			
	}
	
	@Test
	public void jsExecutorTest() {
	    WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement btn = (WebElement)js.executeScript("return document.getElementById('ajaxButton')");
//		btn.click();
//		
		js.executeScript("window.scrollTo(10, document.body.scrollHeight)");
		
		String strTitle = (String)js.executeScript("return document.title");
		System.out.println(strTitle);
	}
	

}
