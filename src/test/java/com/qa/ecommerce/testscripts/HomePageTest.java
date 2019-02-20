package com.qa.ecommerce.testscripts;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

public class HomePageTest {
public TestBase testbase;
public WebDriver driver;
public Properties prop;
public LoginPage loginpage;
public HomePage homepage;

@BeforeMethod

public void setUp(){
	testbase = new TestBase();
	//driver= testbase.init_driver();
	prop=testbase.init_properties();
	driver= testbase.init_driver(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	loginpage= new LoginPage();
	homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}

@Test(enabled=false)

public void VerifyHomePageTitleTest(){
	
	String title = homepage.verifyPageTitle();
	
	Assert.assertEquals(title, "My account - My Store", "This is not correct title");
}

@Test(enabled=false)
public void VerifyHomePageUrlTest(){
	String url = homepage.verifycurrentUrl();
	Assert.assertEquals(url, "http://automationpractice.com/index.php?controller=my-account", "url is not valid");
}

@Test(enabled=false)
public void verifyTabsTest(){
	Assert.assertTrue(homepage.VerifyWomen(),"women tab is not displayed");
	Assert.assertTrue(homepage.VerifyDresses(),"dresses tab is not displayed");
	Assert.assertTrue(homepage.VerifyTshirts(), "tshirts tab is not displayed");
	}

@Test(enabled=false)
public void SearchBoxTest(){
	Assert.assertTrue(homepage.verifySearch(),"List of items in stock");
}
@Test(enabled=true)

public void verifyCompareTest(){
	
	String title= homepage.verifyCompare();
	Assert.assertEquals(title, "Printed Chiffon Dress - My Store");
}

@Test(enabled= false)

public void lowestPriceSelectionTest(){
	homepage.lowestpriceSelection();
}

@Test(enabled=false)
public void verifyTshirtsAddtoCartTest(){
	
Assert.assertTrue(homepage.verifyTShirtsAddtoCart(),"Product not added successfully");
}

@AfterMethod


public void teardown(){
	//driver.quit();
}
	
	
////*[@id="product_comparison"]/tbody/tr[1]/td[3]/div[5]/div/div/a[1]/span	
	
	
	
}
