package testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {
    @Test(groups="SmokeTest")
    public void getAllValues() {
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/tables");
	List<WebElement> items = driver.findElements(By
		.xpath("//table[@id='table1']//td[contains(text(), 'Jason')]//following-sibling::td"));
	System.out.println(items.size());
	for(WebElement item: items) {
	    System.out.println(item.getText());
	}
	
	
    }
}
