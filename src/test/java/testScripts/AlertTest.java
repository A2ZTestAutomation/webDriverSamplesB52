package testScripts;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AlertTest {

    WebDriver driver;
    WebDriverWait wait;
    Properties prop;

    @BeforeTest
    public void setup() throws IOException {
	String path = System.getProperty("user.dir") 
		+ "//src//test//resources//configFiles//config.properties";
	FileInputStream fin = new FileInputStream(new File(path));
	prop = new Properties();
	prop.load(fin);
	String strBrowser = prop.getProperty("browser");
	if (strBrowser.equalsIgnoreCase("chrome")) {
	    driver = new ChromeDriver();
	}
	else if(strBrowser.equalsIgnoreCase("edge")) {
	    driver = new EdgeDriver();
	}
	wait = new WebDriverWait(driver, Duration.ofSeconds(18));
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));

    }

    @Test
    public void variousAlerts() {

	driver.findElement(By.id("alertBtn")).click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert = driver.switchTo().alert();
//	System.out.println(alert.getText());
	Assert.assertEquals(alert.getText(), "I am an alert box!");
	alert.accept();

	driver.findElement(By.id("confirmBtn")).click();
	Alert confirm = driver.switchTo().alert();
	System.out.println(confirm.getText());
	Assert.assertEquals(confirm.getText(), "Press a button!");
	confirm.dismiss();

    }

    @Test
    public void popupWindowHandle() {
	String parentWin = driver.getWindowHandle();
	System.out.println(parentWin);
	driver.findElement(By.xpath("//button[contains(text(), 'New Tab')]")).click();
	Set<String> wins = driver.getWindowHandles();
	System.out.println("No. of windows..." + wins.size());
	System.out.println(driver.getTitle());
	for (String win : wins) {
	    System.out.println(win);
	    if (!win.equalsIgnoreCase(parentWin)) {
		driver.switchTo().window(win);
		System.out.println("Child Window..." + driver.getTitle());
//	       driver.close();
	    }
	}
	driver.switchTo().window(parentWin);
//	driver.findElement(By.id("alertBtn")).click();
	driver.quit();

    }
}
