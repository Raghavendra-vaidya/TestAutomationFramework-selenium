package com.seleniumTA.Utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Utility 
{
	/*** this method captures the screenshot and places the images in class name folder ***/
	public static void captureScreenshot(WebDriver driver, ITestResult result) 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String methodName = result.getName();
		String packageName = result.getInstanceName();
		String nameCollection[] = packageName.split(Pattern.quote("."));
		String classname = nameCollection[nameCollection.length-1];
		File folder = new File("./screenshots/"+classname+"/"); 
		File destination = new File("./screenshots/"+classname+"/"+methodName+".jpg");
		try 
		{
		if(!folder.exists()) 
		{
			folder.mkdir();
			FileUtils.copyFile(source, destination);
		}
		else if(folder.exists() && (!destination.exists())) 
		{
				FileUtils.copyFile(source, destination);		
		}
		else 
		{
			return;
		}
		}
		catch (IOException e) 
		{
		
			e.printStackTrace();
			return;
		}
	}
	
	/*** this method deletes the screenshots ***/
	public static void deleteScreenShots() 
	{
		File parentFolder = new File("./screenshots/");
		
		if(parentFolder.exists() && parentFolder.list().length>0) 
		{
			String subItems[] = parentFolder.list();
			for(String item: subItems) {
				FileUtils.deleteQuietly(new File("./screenshots/"+item));
			}
			
		}
		else return;			
	}
	
	/***Robot class screenshot method**/
	
	public static boolean robotScreenShot(ITestResult result) 
	{
		boolean success = false;
		String methodName = result.getName();
		String packageName = result.getInstanceName();
		String nameCollection[] = packageName.split(Pattern.quote("."));
		String classname = nameCollection[nameCollection.length-1];
		File folder = new File("./screenshots/"+classname+"/"); 
		File destination = new File("./screenshots/"+classname+"/"+methodName+".jpg");
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		try {
			Robot rbot = new Robot();
			BufferedImage screenshot=rbot.createScreenCapture(screenSize);
			if(!folder.exists()) 
			{
				folder.mkdir();
				ImageIO.write(screenshot, "jpg", destination);
				System.out.println("success");
				return success = true;
			}
			else if(folder.exists()&& ((!destination.exists())))
			{
				ImageIO.write(screenshot, "jpg", destination);
				System.out.println("success");
				return success = true;
			}
			else return success;
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return success;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return success;
		}	
	}

	/***robot class method to upload file*/
	
	public static boolean uploadFile(String filepath) 
	{
		boolean success = false;
		
		StringSelection stringSelection = new StringSelection(filepath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
 
        Robot robot = null;
 
        try {
            robot = new Robot();
            robot.delay(250);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(150);
            robot.keyRelease(KeyEvent.VK_ENTER);            
            return success = true;
        } 
        catch (AWTException e) 
        {
            e.printStackTrace();
            return success;
        }
        catch(Exception e) 
        {
        	e.printStackTrace();
        	return success;
        }
         
	}
}


