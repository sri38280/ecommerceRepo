package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.ComparePage;
import com.qa.ecommerce.pages.ContactusPage;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

public class ComparisionPageTest {
public TestBase testbase;
public WebDriver driver;
public Properties prop;

public LoginPage loginpage;
public HomePage homepage;
public ComparePage comparisionpage;

@BeforeMethod

public void setUp(){
	testbase= new TestBase();
	prop = testbase.init_properties();
	driver = testbase.init_driver(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	loginpage= new LoginPage();
	homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	comparisionpage = new ComparePage();
	}
@Test(enabled=false)

public void placeAnOrderTest(){
	comparisionpage.oderItems();
	
}

@Test
public void getOrderDetails(){
	
	//comparisionpage.clickDetailsButton(prop.getProperty("orderno1"));
	//comparisionpage.clickOrderRefNo(prop.getProperty("orderno1"));
	comparisionpage.productCompare(prop.getProperty("orderno1"),prop.getProperty("orderno2"), prop.getProperty("orderno3"));
}


@AfterMethod

public void teardown(){
	//driver.quit();
}

}
