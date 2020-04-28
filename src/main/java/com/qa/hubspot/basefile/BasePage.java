package com.qa.hubspot.basefile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	public WebDriver init_driver(String browsername)
	{
		if(browsername.equals("Chrome"))
		{
			System.out.println("Chrome browser");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.out.println("Firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Browser entered is not available, enter the correct one");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public Properties init_properties() throws IOException
	{
		prop=new Properties();
		String path="src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
	    
			FileInputStream ip =new FileInputStream(path);
			prop.load(ip);
		    

		
	    return prop;
	    
	}

}
