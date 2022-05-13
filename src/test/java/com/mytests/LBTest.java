package com.mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LBTest extends LocalBrowsersBaseTest {

	public void doLogin() {
		driver.get("http://127.0.0.1:5500/index.html");
		driver.findElement(By.id("name")).sendKeys("Puneet");
		driver.findElement(By.id("department")).sendKeys("Test Automation");
		driver.findElement(By.id("btn")).click();
	}

	@Test(priority = 1)
	public void checkInventoryItemTest() {
		doLogin();
		Assert.assertTrue(driver.findElement(By.id("demo")).getText().equalsIgnoreCase("Succeeded"));
	}

}
