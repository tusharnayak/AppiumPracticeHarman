package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		//Code to start the server (Every time we don't required to start and stop the server manually)
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\TRanjannayak\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		// Very first time it will automatically install the app and run the code and next after it will run only code not installationpart.
		// Appium code >> appium Server >> Mobile execute .
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("PixelAVD"); // emulator (on Android studio)
		options.setChromedriverExecutable("C:\\Users\\TRanjannayak\\Documents");
		options.setCapability("browserName", "Chrome");
		
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);//converted URI to URL after java 20
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
		

}
