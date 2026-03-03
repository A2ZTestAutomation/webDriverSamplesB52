package testScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DisplayTxtTest {
  @Test
  public void verifyDisplaTxt() throws IOException {
      WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationbookstore.dev/");
	driver.findElement(By.id("searchBar")).sendKeys("Test");
	TakesScreenshot scr = (TakesScreenshot)driver;
	File scrFile = scr.getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir") 
		+ "/screenshots/" + System.currentTimeMillis() + ".png";
	FileUtils.copyFile(scrFile, new File(path));
	
	WebElement closeIcon = driver.findElement(By.cssSelector("a[title = 'Clear text']"));
	System.out.println(closeIcon.isDisplayed());
	if(closeIcon.isDisplayed()) {
	    closeIcon.click();
	}
	WebElement bookIcon= driver.findElement(By.id("pid1_thumb"));
	File scrFile1 =bookIcon.getScreenshotAs(OutputType.FILE);
	String path1 = System.getProperty("user.dir") 
		+ "/screenshots/" + System.currentTimeMillis() + ".png";
	FileUtils.copyFile(scrFile1, new File(path1));
      
  }
}
