package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.ContactusPage;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

public class ContactusPageTest {
	
	public TestBase testbase;
public WebDriver driver;
public Properties prop;

public LoginPage loginpage;
public HomePage homepage;
public ContactusPage contactus;

@BeforeMethod

public void setUp(){
	testbase= new TestBase();
	prop = testbase.init_properties();
	driver = testbase.init_driver(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	loginpage= new LoginPage();
	homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	contactus = homepage.GoToContactUsPage();
	}

@Test(enabled=true)
public void sendMessageTest() throws InterruptedException{
	Assert.assertTrue(contactus.sendmessage(prop.getProperty("subheading"),prop.getProperty("orderreference"),Integer.parseInt(prop.getProperty("product")), prop.getProperty("choosefile"), prop.getProperty("message")));
	
}

@Test(enabled=false)

public void verifyContactUsTitleTest(){
	
	String contactustitle= contactus.verifyContactUsPage();
	
	Assert.assertEquals(contactustitle, "Contact us - My Store");
}

}
