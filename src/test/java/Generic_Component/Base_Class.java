package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base_Class {
	
	public Process process;
	public AppiumDriver driver;
	
	Utility_Class c1= new Utility_Class();
	
	public  void Start_Server() throws IOException, InterruptedException
	{
		System.out.println("Hi");
		//start server, invoke node and appiumjs
				String Start_server= "D:\\Appium\\node.exe D:\\Appium\\node_modules\\appium\\bin\\appium.js";
				
				process = Runtime.getRuntime().exec(Start_server);
				
				if(process!=null)
				{
					System.out.println("Appium Server is Started");
				}
				else
				{
					System.out.println("NOT Initialized the server");
				}
				
				Thread.sleep(12000);
	}
	
	
	public  void Init_App() throws IOException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		capabilities.setCapability("appPackage",c1.Reading_Properties("Package_Name"));
		capabilities.setCapability("appActivity",c1.Reading_Properties("Activity_Name"));
		
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}
	
	
	
	public void Explicit_Wait(WebElement ele, long T1)
	{
		
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	
	public void snapshot1(String TC_ID, String Order) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		File file= new File(dateFormat.format(date)+".png");
		
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\June_BB_Project\\Screenshot\\"+TC_ID+"-"+Order+"-"+file));
		
		
	}
	
	public  void Stop_Server() throws InterruptedException
	{
		
		
		//stop the appium server  by using destroy
		
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(5000);
			System.out.println("Appium server Stopped");
		}
	}
	
	

}
