package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.registrationPage;
import com.qa.ecommerce.util.TestUtil;

public class RegistrationPageTest {
	public TestBase testbase;
	public WebDriver driver;
	public Properties prop;
	public registrationPage regnpage;
	
	@BeforeMethod
	
	public void setUP(){
		
		testbase= new TestBase();
		//driver=testbase.init_driver();
		prop= testbase.init_properties();
		driver= testbase.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		regnpage= new registrationPage();
		
		}
@Test(enabled=true)
public void RegnTest(){
	/*regnpage.gotoregnpage(prop.getProperty("email"));
	TestUtil.mediumWait();*/
	
	regnpage.regn();
	//String myAccountPageTitle = driver.getTitle();
	//Assert.assertEquals(myAccountPageTitle, "My account - My Store");
}
	
@Test(enabled=false)

public void verifypersonalInfoLabel(){
	regnpage.gotoregnpage(prop.getProperty("email"));
	TestUtil.mediumWait();
	Assert.assertTrue(regnpage.verifyPersonalInfo(), "personal info label is not found");
}

@Test(enabled=false)
public void verifyAddressLabelTest()
{
	regnpage.gotoregnpage(prop.getProperty("email"));
	TestUtil.longWait();
	Assert.assertTrue(regnpage.verifyAddress(), "address label is not found");
}


	
	@AfterMethod
	
	public void tearDown(){
		
	TestBase.getDriver().quit();
	}
}
