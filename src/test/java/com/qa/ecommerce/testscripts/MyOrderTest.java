package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.MyAccountPage;
import com.qa.ecommerce.pages.MyOrderPage;
import com.qa.ecommerce.util.TestUtil;

public class MyOrderTest {
public TestBase testbase;
public Properties prop;
public WebDriver driver;
public LoginPage loginpage;
public HomePage homepage;
public MyOrderPage mystorepage;
public static MyAccountPage myaccountpage;

@BeforeMethod
public void setUP(){
	
	testbase= new TestBase();
	prop=testbase.init_properties();
	driver= testbase.init_driver(prop.getProperty("browser"));
	loginpage= new LoginPage();
	driver.get(prop.getProperty("url"));
	homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	mystorepage= new MyOrderPage();
	myaccountpage= new MyAccountPage();
	
	
}

@Test(enabled=false)

public void addtoWishListTest(){
	
	mystorepage.AddtoWishList();
	//myaccountpage.checkWishList();
}

@Test(enabled=true) 
public void orderItems(){
	
	mystorepage.oderItems();
	TestUtil.mediumWait();
	mystorepage.shoppingcart();
	
}


@AfterMethod
public void teardown(){
	//driver.quit();
}
	
	
	
	
	
	
	
}
