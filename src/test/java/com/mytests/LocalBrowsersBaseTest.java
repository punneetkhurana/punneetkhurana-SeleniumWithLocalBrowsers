package com.mytests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalBrowsersBaseTest {
	
	
	WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browserName, Method name) {

		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();
		
	
			WebDriverManager.chromedriver().driverVersion("100").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			 driver = new ChromeDriver(options);			

//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
