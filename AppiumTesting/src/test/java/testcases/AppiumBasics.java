package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{

	@Test
	public void wifiSetttingName() throws MalformedURLException, URISyntaxException, InterruptedException {
		
//		configureAppium();
		//Locators in Appium : Xpath, id, accessibilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']\r\n"+ "")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\r\n"
				+ "")).click();
		String text = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(text, "WiFi settings");
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("abcdef");
		driver.findElement(By.id("android:id/button1")).click();
		
//		tearDown();
		
		
	}
	
}
