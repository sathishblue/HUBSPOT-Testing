package com.qa.hubspot.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.basefile.BasePage;
import com.qa.hubspot.page.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	BasePage basepage;
	
	@BeforeTest
	public void setup() throws IOException {
		basepage=new BasePage();
		prop=basepage.init_properties();
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		driver=basepage.init_driver(browsername);
		driver.get(prop.getProperty("url"));
		loginpage=new LoginPage(driver);
	}
	@Test
	public void verifyloginpagetest() throws InterruptedException
	{
		Thread.sleep(5000);
		String title=loginpage.gettitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}
	@Test
	public void verifysignuplinktest()
	{
		
		Assert.assertTrue(loginpage.checksignuplink());
	}
	@Test
	public void doLogin()
	{
		loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	


}
