package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;

import com.qa.ecommerce.pages.WomenPage;

public class WomenPageTest {
	public TestBase testbase;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	public WomenPage womenpage;

	@BeforeMethod

	public void setUp(){
		testbase = new TestBase();
		
		prop=testbase.init_properties();
		driver= testbase.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginpage= new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		womenpage = homepage.GotoWomenPage();
		/*topspage= homepage.gotoTopsPage();
		topspage.scrolldown();*/
	}
	
	@Test(enabled=true)
	public void shirtsTest() throws InterruptedException {
		womenpage.FadedShortSleeveTshirtsShopCart();
		String order= womenpage.retrieveOrderNo();
		System.out.println(order);
			}
	
	@Test(enabled=false)
	public void verifyWomenLabelsTest(){
		Assert.assertTrue(womenpage.verifyDresses(), "Dresses tab is not displayed");
		Assert.assertTrue(womenpage.verifyTops(), "Tops tab is not displayed");
	}
	
	@Test(enabled=false)
	public void CatalogSelectionTest(){
		
		Assert.assertTrue(womenpage.catalogSelection(),"Catalog Selection is not pick up the product");
	}
	
	@Test (enabled=false)
	public void writeAReviewTest(){
		Assert.assertTrue(womenpage.writeaReview(), "write a review is not working");
		
	}
	
	@AfterMethod

	public void teardown(){
	//	driver.quit();
	}

}
