package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.DressesPage;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.WomenPage;

public class DressesPagesTest {

	public TestBase testbase;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	public WomenPage womenpage;
	public DressesPage dressespage;
	
	@BeforeMethod
	
	public void setUp(){
		
		testbase = new TestBase();
		prop= testbase.init_properties();
		driver=testbase.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginpage= new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dressespage = homepage.GotoDressesPage();
		
	}
	
	@Test
	
	public void verifyDressesLabelsTest()
	{
		Assert.assertTrue(dressespage.verifyCasualDresses(),"Casual dresses has not been displayed");
		Assert.assertTrue(dressespage.verifyEveningDresses(), "Evening dresses has not been displayed");
		Assert.assertTrue(dressespage.verifySummerDresses(), "Summer dresses has not been displayed");
	}
	
	@AfterMethod
	
	public void teardown(){
		driver.quit();
	}
	
}
