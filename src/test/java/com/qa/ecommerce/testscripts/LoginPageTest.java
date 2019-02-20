package com.qa.ecommerce.testscripts;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mytests.LoginTest;
import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.util.TestUtil;

import TestNGListenerConcept.CustomListener;
//@Listeners(CustomListener.class)
//@author Sri
public class LoginPageTest {

	
	public TestBase testbase;
	//public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	Logger log = Logger.getLogger(LoginTest.class);
	@BeforeMethod
	
	public void setUP(){
		log.info("****************************** Starting test cases execution  *****************************************");
		testbase = new TestBase();
		//driver = testbase.init_driver();
		prop= testbase.init_properties();
		String browser = prop.getProperty("browser");
		log.info("launching chrome broswer");
		testbase.init_driver(browser);
		log.info("entering application URL.......");
		TestBase.getDriver().get(prop.getProperty("url"));
		loginpage= new LoginPage();
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	@Test(priority=2,enabled=false)
	public void loginTest(){
			
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//loginpage.logout();
	}
	@Test(dependsOnMethods="login",priority=3,enabled=false)
	
	public void verifyPageTitleTest(){
		
		String title = loginpage.verifyPageTitle();
		
		
		Assert.assertEquals(title, "My account - My Store");
	}
	
	@Test(priority=1,enabled=false)
	
	public void verifyforgotpwdLinkTest(){
		
		Assert.assertTrue(loginpage.verifyforgotpwdlink());
	}
	
	
	
	
	@Test(priority=4,enabled=false)
	public void logoutTest(){
				
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginpage.logout("Saish Chowdari");
	
	}
	
	@Test(priority=5,enabled=true)
	public void ExceldataDriven() throws IOException{
		
		loginpage.loginToAutomationExcel();
		System.out.println("test");
		//String title = driver.getTitle();
		//Assert.assertEquals(title, "My account - My Store", "logged in successfully");
	}
	
	
	/*@Test(dataProvider ="getdata")
	
	public void validate(String uname,String pwd, String error){
		
		loginpage.clicksigninlink();
		TestUtil.shortWait();
		loginpage.loginToAutomationExcel();
		assert driver.getPageSource().contains(error);
		
		
	}
	
	
	@DataProvider
	
	public Object[][] getdata(){
		Object[][] credentials ={{"username", " ", "There is 1 error an email address required"},{" ","password", "there is 1 error password is required"}};
		
		return credentials;
	}
	*/
	
	
	@DataProvider(name = "getLoginTestData")
	public Object[][] LoginTestData(){
		return TestUtil.getTestData("login");
	}
	
	@Test(dataProvider = "getLoginTestData", enabled = false)
	public void LoginTest(String emailId, String password, String errormsg) throws IOException{
		loginpage.loginDataProvider(emailId, password);
		Assert.assertFalse(TestBase.getDriver().getPageSource().contains(errormsg), "EmailId and password are valid");
		//TestUtil.takeScreenshotAtEndOfTest();
	
	
	}
	@AfterMethod
	public void teardown(){
		TestBase.getDriver().quit();
	}
}
