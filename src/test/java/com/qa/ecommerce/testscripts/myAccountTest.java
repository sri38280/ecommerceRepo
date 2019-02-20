package com.qa.ecommerce.testscripts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.pages.HomePage;
import com.qa.ecommerce.pages.LoginPage;
import com.qa.ecommerce.pages.MyAccountPage;
import com.qa.ecommerce.pages.MyOrderPage;
import com.qa.ecommerce.pages.WomenPage;
import com.qa.ecommerce.util.TestUtil;

public class myAccountTest {

	public TestBase testbase;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public HomePage homepage;
	public WomenPage womenpage;
	public MyAccountPage myaccountpage;
	public MyOrderPage mystorepage;

	@BeforeMethod

	public void setUp(){
		testbase = new TestBase();
		
		prop=testbase.init_properties();
		driver= testbase.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		loginpage= new LoginPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		womenpage = homepage.GotoWomenPage();
		myaccountpage=homepage.GotoMyAccountPage();
		mystorepage= homepage.GotoMyStore();
		//mystorepage = new MyStorePage(driver);
	
	}
	
	@Test(enabled=false)
	public void verifyOrderDetailsTest() throws InterruptedException {
		//mystorepage.oderItems();
		String orderno=mystorepage.retrieveOrderNo();
		System.out.println(orderno);
		/*using for loop
		 * 
		 * myaccountpage.myAccountclick();
		myaccountpage.verifyOrderAccountHistory();
		myaccountpage.clickOrderRefNo((prop.getProperty("orderno")));*/
		
		myaccountpage.clickDetailsButton(orderno);
		//myaccountpage.clickPDF(orderno);
	}
	
	@Test(enabled=true)
	public void verifyReorderTest(){
		
		myaccountpage.reorder(prop.getProperty("orderno"));
		TestUtil.longWait();
		mystorepage.shoppingcart();
	}
	
	@Test(enabled=false)
	
	public void checkWishListTest(){
		mystorepage.AddtoWishList();
		TestUtil.mediumWait();;
		myaccountpage.checkWishList();
	}
	
	@Test(enabled=false)
	public void orderSortByDateTest(){
		Assert.assertTrue(myaccountpage.OrdersSortByDate(), "Order details are not displayed");
	}
	@Test(enabled=false)
	public void orderSortByAmount(){
		Assert.assertTrue(myaccountpage.ordersSortByAmount(), "Order details are not displayed");
	}
	
	
}
