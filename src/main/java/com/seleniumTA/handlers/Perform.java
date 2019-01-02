package com.seleniumTA.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Perform
{
	public static void login(WebDriver driver, String userName, String password) 
	{
		driver.findElement(By.xpath("")).sendKeys(userName);
		driver.findElement(By.xpath("")).sendKeys(password);
		driver.findElement(By.xpath("")).click();
		
		/***this is a dummy method to show how perform class methods has to be implemented**/
	
	}
	
	
}
