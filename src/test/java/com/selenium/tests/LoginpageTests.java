package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.Configuration.Base;
import com.selenium.Configuration.CreateWebDriver;
import com.seleniumTA.Utilities.Utility;

public class LoginpageTests extends Base
{	
	@BeforeSuite
	public void clearscr() {
		Utility.deleteScreenShots();
	}
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser) 
	{
		driver = CreateWebDriver.instance(browser);
		//todo initiate page class object
	}
	
	@Test(description="this test description", priority=1)
	public void Tc_login_01() throws Exception 
	{
		Thread.sleep(3000);
		Assert.assertTrue(false, "Purposely failed test to check the robot screenshot method");
		
	}
	
	
	@Test(description="this test description", dependsOnMethods= {"Tc_login_01" })
	public void Tc_login_02() {
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
