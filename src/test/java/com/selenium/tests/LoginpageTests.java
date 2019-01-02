package com.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.Configuration.Base;
import com.selenium.Configuration.CreateWebDriver;

public class LoginpageTests extends Base
{	
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser) 
	{
		driver = CreateWebDriver.instance(browser);
		//todo initiate page class object
	}
	
	@Test(description="this test description", dependsOnMethods= {""}, priority=2)
	public void Tc_login_01() {
		
	}
	
	
	@Test(description="this test description", dependsOnMethods= {""}, priority=3)
	public void Tc_login_02() {
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
