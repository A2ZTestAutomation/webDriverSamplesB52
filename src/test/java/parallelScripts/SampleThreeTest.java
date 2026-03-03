package parallelScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleThreeTest {
	WebDriver driver;
	@Test
	public void testOne() {
		
		long id = Thread.currentThread().getId();
		System.out.println("Test31 in SampleThree..." +id);
	}

	@Test
	public void testTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Test32 in SampleThree..."+id);
	}

	@Test
	public void testThree() {
		long id = Thread.currentThread().getId();
		System.out.println("Test33 in SampleThree..."+id);
		
	}

	@Test(invocationCount = 6, threadPoolSize = 3, timeOut=10000)
	public void testFour() {
		long id = Thread.currentThread().getId();
		System.out.println("Test34 in SampleThree..."+id);
	}

}
