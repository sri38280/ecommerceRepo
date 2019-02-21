package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;

public class VerifyBrokenLinksTest {
//public WebDriver driver;
public Properties prop;
public TestBase testbase;
public HomePage homepage;

@BeforeTest

	public void setUp(){
	
	testbase = new TestBase();
	prop= testbase.init_properties();
	testbase.init_driver(prop.getProperty("browser"));
	//driver.get(prop.getProperty("url"));
	homepage= new HomePage();
	
}

@Test

public void BrokenlinksTest(){
	homepage.verifyBrokenLinks(prop.getProperty("url"));
}


@AfterTest

public void quit(){
	TestBase.getDriver().quit();
}
	
	
	
	
}
