package com.selenium.Configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.seleniumTA.Utilities.GetData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateWebDriver {

	
	public static WebDriver instance(String browser) 
	{
		WebDriver driver = null;
		Integer imWaitTime=Integer.valueOf(GetData.fromProperties("configuration", "implicitWaitTime"));
		String url = GetData.fromProperties("configuration", "URL");
		switch (browser) 
		{
			case "ie":
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions iop = new InternetExplorerOptions();
			iop.introduceFlakinessByIgnoringSecurityDomains();
			driver = new InternetExplorerDriver(iop);
			driver.manage().window().maximize();
				break;
			
			case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions cop = new ChromeOptions();
			cop.setExperimentalOption("useAutomationExtension", false);
			cop.addArguments("--start-maximized");
			driver = new ChromeDriver(cop);
			
				break;	
		
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			default:		
				ChromeOptions cop2 = new ChromeOptions();
				cop2.setExperimentalOption("useAutomationExtension", false);
				cop2.addArguments("--start-maximized");
				driver = new ChromeDriver(cop2);
				break;
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(imWaitTime, TimeUnit.SECONDS);
		return driver;
	}
}
