package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilclass {
	
	WebDriver driver;
	
	public Utilclass()
	{
		this.driver=driver;
	}
	
	public WebElement getelement(By locator)
	{
		WebElement element=driver.findElement(locator);
		return element;
	}

}
