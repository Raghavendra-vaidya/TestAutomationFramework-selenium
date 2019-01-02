package com.selenium.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CreateWebDriver {

	
	public static WebDriver instance(String browser) 
	{
		WebDriver driver = null;
		switch (browser) 
		{
			case "ie":
			InternetExplorerOptions iop = new InternetExplorerOptions();
			iop.introduceFlakinessByIgnoringSecurityDomains();
			driver = new InternetExplorerDriver(iop);
			driver.manage().window().maximize();
				break;
			
			case "chrome":
			ChromeOptions cop = new ChromeOptions();
			cop.setExperimentalOption("useAutomationExtension", false);
			cop.addArguments("--start-maximized");
			driver = new ChromeDriver();
			
				break;	
		
			case "firefox":
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			default:
				
				ChromeOptions cop2 = new ChromeOptions();
				cop2.setExperimentalOption("useAutomationExtension", false);
				cop2.addArguments("--start-maximized");
				driver = new ChromeDriver();
				break;
		}
		
		
		return driver;
	}
}
