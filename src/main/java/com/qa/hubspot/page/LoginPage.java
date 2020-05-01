package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.basefile.BasePage;
import com.qa.hubspot.util.Utilclass;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	By email=By.id("username");
	By password=By.id("password");
	By submit=By.id("loginBtn");
	By signup=By.linkText("Sign up");
	Utilclass util=new Utilclass();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String gettitle()
	{
		return driver.getTitle();
	}
	public boolean checksignuplink()
	{
		return driver.findElement(signup).isDisplayed();
	}
	public HomePage dologin(String username,String pwd)
	{
		driver.findElement(email).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submit).click();
		return new HomePage();
		 	
	}
	

}
