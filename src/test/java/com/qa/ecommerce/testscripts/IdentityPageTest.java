package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.IdentityPage;
import com.qa.ecommerce.pages.LoginPage;

public class IdentityPageTest {
	public TestBase testbase;
//	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	public IdentityPage identitypage;

	@BeforeMethod

	public void setUp(){
		testbase = new TestBase();
		//driver= testbase.init_driver();
		prop=testbase.init_properties();
	 testbase.init_driver(prop.getProperty("browser"));
		TestBase.getDriver().get(prop.getProperty("url"));
		loginpage= new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		identitypage=homepage.GotoIndentity();
		
	}
	
	@Test
	
	public void updatePersonalInfo(){
		
		Assert.assertTrue(identitypage.YourPersonalInfoUpdate(),"Personal info has not been updated");
	}

	@AfterTest
	
	public void teardown(){
		TestBase.getDriver().quit();
	}
	
	
	
	
}
