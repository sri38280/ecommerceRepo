package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

public class SearchPageTest {
	
		public TestBase testbase;
		//public WebDriver driver;
		public Properties prop;
		public LoginPage loginpage;
		public HomePage homepage;

		@BeforeMethod

		public void setUp(){
			testbase = new TestBase();
			//driver= testbase.init_driver();
			prop=testbase.init_properties();
			 testbase.init_driver(prop.getProperty("browser"));
			TestBase.getDriver().get(prop.getProperty("url"));
			loginpage= new LoginPage();
			homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			
		}
		@Test(enabled=false)
		public void SearchBoxTest(){
			Assert.assertTrue(homepage.verifySearch(),"List of items in stock");
		}
		@Test(enabled=false)

		public void verifyCompareTest(){
			
			String title= homepage.verifyCompare();
			Assert.assertEquals(title, "Printed Chiffon Dress - My Store");
		}

		@Test(enabled= true)

		public void lowestPriceSelectionTest(){
			homepage.lowestpriceSelection();
		}

		public void teardown(){
			TestBase.getDriver().quit();
		}
}
