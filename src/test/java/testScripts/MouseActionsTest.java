package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionsTest {
    @Test
    public void actionTest() {
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	WebElement btnPoint = driver.findElement(By.cssSelector("button.dropbtn"));
	
	action.scrollToElement(driver.findElement(
		By.xpath("//button[contains(text(), 'Copy Text')]")));
	action.moveToElement(btnPoint).perform();
	WebElement link = driver.findElement(By.linkText("Laptops"));
	action.click(link).perform();
	
//	action.moveToElement(btnPoint).click(driver.findElement(By.linkText("Laptops"))).build().perform();
		
	action.doubleClick(driver.findElement(
		By.xpath("//button[contains(text(), 'Copy Text')]"))).perform();
	WebElement field2 = driver.findElement(By.id("field2"));
	action.contextClick(field2).perform();
    }
}
