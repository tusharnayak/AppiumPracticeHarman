package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	
	@Test
	public void browserTest() {
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle()); 
		driver.findElement(By.name("q")).sendKeys("Testla cars");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		
	}

}
