package testScripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSampleTest {
  @Test
  public void loginTest() {
      Map<String, Object> prefs = new HashMap();
      // Disable the "Save password" pop-up
      prefs.put("credentials_enable_service", false);
      prefs.put("profile.password_manager_enabled", false);
      // Disable the "Change your password" pop-up related to data breaches (for newer Chrome versions)
      prefs.put("profile.password_manager_leak_detection", false);

      // Create ChromeOptions object
      ChromeOptions options = new ChromeOptions();
      options.setExperimentalOption("prefs", prefs);
      WebDriver driver = new ChromeDriver(options);
      
      driver.manage().window().maximize();
//      driver.get("https://the-internet.herokuapp.com/login");
      driver.navigate().to("https://the-internet.herokuapp.com/login");
      WebElement inpUser = driver.findElement(By.id("username"));
      inpUser.sendKeys("tomsmith");
//      inpUser.clear();
//      inpUser.sendKeys(Keys.BACK_SPACE);
     
      driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//      driver.findElement(By.className("radius")).click();
//      driver.findElement(By.className("fa fa-2x fa-sign-in")).click();
//      driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
      driver.findElement(By.className("radius")).submit();
      
      driver.navigate().back();
      System.out.println("Current URL ..."+driver.getCurrentUrl());
      
      System.out.println("Title...."+ driver.getTitle());
      Assert.assertEquals(driver.getTitle(), "The Internet");
      driver.navigate().forward();
      //input[@name="username" and @type="text"]
      
//      driver.findElement(By.tagName("button")).click();
//      driver.findElement(By.linkText("Elemental Selenium")).click();
//      driver.findElement(By.partialLinkText("Selenium")).click();
        
      
      
  }
}
