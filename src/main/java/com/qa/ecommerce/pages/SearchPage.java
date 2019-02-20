package com.qa.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class SearchPage extends TestBase {
	@FindBy(id="search_query_top")
	WebElement SearchBox;
	////*[@id="categories_block_left"]/div/ul/li[1]/a
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement submitSearch;
	
	@FindBy(xpath="//select[@id='selectProductSort']")
	WebElement sortBy;
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactus;
	
	@FindBy(xpath="//span[@class='available-now']")
	WebElement InStock;
	
	@FindBy(xpath="//form[@class='compare-form']")
	WebElement compare;
	
	@FindBy(xpath="//img[@title='Printed Summer Dress']")
	WebElement PrintedSummerDress;
	
	@FindBy(xpath="//img[@title='Printed Chiffon Dress']")
	WebElement PrintedChiffonDress;
	
	@FindBy(xpath="(//a[@class='add_to_compare' and text()='Add to Compare'])[1]")
	WebElement addToCompare1;
	
	@FindBy(xpath="(//a[@class='add_to_compare' and text()='Add to Compare'])[2]")
	WebElement addToCompare2;
	
	
	@FindBy(xpath="//* [@data-id-product='7'] /span ")
	WebElement addtocart1;
	
	@FindBy(xpath="//p[@id='add_to_cart']")
	WebElement addToCart;
	
	@FindBy(xpath="(//a[@title='View'])[1]")
	WebElement view1;
	
	@FindBy(xpath="(//a[@title='View'])[2]")
	WebElement view2;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement ContinueShopping;
	
	@FindBy(xpath="//td[@class='ajax_block_product comparison_infos product-block product-7']//div[@class='prices-container']")
	WebElement pricescontainer7;
	
	@FindBy(xpath="//td[@class='ajax_block_product comparison_infos product-block product-6']//div[@class='prices-container']")
	WebElement pricescontainer6;
	
	@FindBy(xpath="//td[@class='ajax_block_product comparison_infos product-block product-7']//span[text()='View']")
	WebElement View7;
	
	@FindBy(xpath="//td[@class='ajax_block_product comparison_infos product-block product-6']//span[text()='View']")
	WebElement View6;
	
	

public SearchPage(){
	//this.getDriver() = driver;
	PageFactory.initElements(getDriver(), this);
}

public boolean verifySearch(){
	
	SearchBox.sendKeys("Printed Chiffon Dress");
	TestUtil.shortWait();
	submitSearch.click();
	TestUtil.longWait();
	Select select = new Select(sortBy);
	select.selectByVisibleText("Price: Lowest first");
	TestUtil.longWait();
		
	return InStock.isDisplayed();
}

public String verifyCompare(){
	SearchBox.sendKeys("Printed Chiffon Dress");
	TestUtil.shortWait();
	submitSearch.click();
	TestUtil.mediumWait();
	Select select = new Select(sortBy);
	select.selectByVisibleText("Price: Lowest first");
	TestUtil.mediumWait();
	Actions action = new Actions(getDriver());
	action.moveToElement(PrintedChiffonDress).moveToElement(addToCompare1).click().build().perform();
	TestUtil.mediumWait();
	action.moveToElement(PrintedSummerDress).moveToElement(addToCompare2).click().build().perform();
	TestUtil.mediumWait();
	action.moveToElement(PrintedChiffonDress).moveToElement(addToCompare1).click().build().perform();	
	TestUtil.longWait();
	compare.click();
	TestUtil.mediumWait();
	view1.click();
	TestUtil.mediumWait();
	addToCart.click();
	TestUtil.mediumWait();
	ContinueShopping.click();
	TestUtil.mediumWait();
	
	return getDriver().getTitle();
}

public void lowestpriceSelection(){
	
	SearchBox.sendKeys("Printed Chiffon Dress");
	TestUtil.shortWait();
	submitSearch.click();
	TestUtil.mediumWait();
	Select select = new Select(sortBy);
	select.selectByVisibleText("Price: Lowest first");
	TestUtil.mediumWait();
	Actions action = new Actions(getDriver());
	
	action.moveToElement(PrintedChiffonDress).moveToElement(addToCompare1).click().build().perform();
	TestUtil.mediumWait();
	action.moveToElement(PrintedSummerDress).moveToElement(addToCompare2).click().build().perform();
	TestUtil.longWait();
	action.moveToElement(PrintedChiffonDress).moveToElement(addToCompare1).click().build().perform();
	TestUtil.mediumWait();
	
	compare.click();
	TestUtil.mediumWait();
	
String price6 =pricescontainer6.getText();
System.out.println("price6: " + price6);
double price6Actual=Double.parseDouble(price6.substring(1,6));
System.out.println("Price6 Actual: "+price6Actual);
String price7 =pricescontainer7.getText();
System.out.println("price7: " + price7);
double price7Actual= Double.parseDouble(price7.substring(1,6));
System.out.println("Price 7 Actual:"+ price7Actual);
//addtocart1.click();
if (price6Actual<price7Actual){
	
	View6.click();
	 
  }else{
	 View7.click();
  }
}
}
