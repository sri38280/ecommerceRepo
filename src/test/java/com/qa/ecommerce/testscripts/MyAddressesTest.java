package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.AddressesPage;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

public class MyAddressesTest {
	
	public TestBase testbase;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginpage;
	public AddressesPage addresspage;
	public HomePage homepage;
	
	@BeforeTest
	
	public void setUP(){
	
	testbase= new TestBase();
	prop = testbase.init_properties();
	driver = testbase.init_driver(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	loginpage= new LoginPage();
	homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	addresspage= homepage.GotoMyAddress();
	

}
	
@Test(enabled = false)
public void updateAddressTest(){
	Assert.assertTrue(addresspage.UpdateAddress());
}


@Test (enabled=true)
public void addAddressNoDeleteTest(){
	
	
	if (addresspage.deleteaddress()==true){
	addresspage.addaddressNOdeleteBtn();
	}
	else{
		addresspage.deleteaddress();
	}
	
	
}

@Test(enabled=false)

public void addanaddressTest(){
	addresspage.addanaddress();
}
	@AfterMethod
	
	public void teardown(){
		//driver.quit();
	}


}
