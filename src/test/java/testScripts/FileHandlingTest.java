package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileHandlingTest {
    WebDriver driver;
    @BeforeTest
    public void setupExtent() {
	
    }
    
    @BeforeMethod
    public void setup() {
	driver = new ChromeDriver();
    }
    @Test
    public void fileUploadTest() {
	driver.get("https://the-internet.herokuapp.com/upload");
	WebElement addFile = driver.findElement(By.id("file-upload"));
	String strPath = System.getProperty("user.dir") 
		+ "//screenshots//" + "1770870019086.png";
	addFile.sendKeys(strPath);
	driver.findElement(By.id("file-submit")).click();
    }
    
    @Test(enabled=false)
    public void downloadTest() {
//	ChromeOptions options = new ChromeOptions();
//	Map<String, Object> prefs = new HashMap<String, Object>();
//	prefs.put("download.prompt_for_download", false);
//	 options.setExperimentalOption("prefs", prefs);
	
	driver.get("https://the-internet.herokuapp.com/download");
	WebElement txtFile = driver.findElement(By.linkText("test-file.txt"));
	txtFile.click();
	
    }
    @Test
    public void shadowDOMTest() {
	driver.get("https://testautomationpractice.blogspot.com/");
	WebElement shadowHost = driver.findElement(By.id("shadow_host"));
	SearchContext cont = shadowHost.getShadowRoot();
	cont.findElement(By.cssSelector("input[type='text']"))
		.sendKeys("ShadowInput");
	}
}
