package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class MyAccountPage extends TestBase {
	
	@FindBy(xpath="//a[@class='account']")
	WebElement myaccount;
	
	@FindBy(xpath="//i[@class='icon-list-ol']")
	WebElement orderaccounthistory;
	
	/*@FindBy(xpath="(//tbody/tr/td)[1]")
			WebElement orderrefno;*/
	
	@FindBy(xpath="//div[@class='block-center']/descendant::table[1]//tbody/tr[1]/td[1]/a")
	WebElement orderrefno;
	
	@FindBy(xpath="(//tbody/tr/td)[7]/a[@class='btn btn-default button button-small']")
	WebElement details;
	
	@FindBy(xpath="(//tbody/tr/td)[7]/a[@title='Reorder']")
	WebElement reorder;
	
	@FindBy(xpath="//a[@title='Add']")
	WebElement PlusIcon;
	
	@FindBy(xpath="//a[@title='Continue shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath="(//tbody/tr/td)[6]/a[@class='link-button']")
	WebElement pdf;
	
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement MyWishLists;
	
	@FindBy(xpath="(//tbody/tr/td)[5]/a")
	WebElement myWishListView;
	
	@FindBy(xpath="//input[@id='quantity_1_0']")
	WebElement wishlistQuantity;
	
	
	@FindBy(xpath="//select[@id='priority_1_0']")
	WebElement wishlistPriority;
	
	@FindBy(xpath="(//span[text()='Save'])[1]")
	WebElement WishListSave;
	/*@FindBy(xpath="(//tbody//a[@class='color-myaccount'])[1]")
	WebElement orderrefno;*/
	
	@FindBy(xpath="(//thead/tr/th)[2]")
	WebElement orderSortbyDate;
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement detailsPageheader;
	
	@FindBy(xpath="(//thead/tr/th)[3]")
	WebElement orderSortByAmount;
	
	
	
	public MyAccountPage(){
		//this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public void myAccountclick(){
		myaccount.click();
		TestUtil.shortWait();
	}
	
	public void verifyOrderAccountHistory(){
		/*WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(orderaccounthistory));*/
		orderaccounthistory.click();
		TestUtil.longWait();
		//return orderaccounthistory.isDisplayed();
	}
	
	public void clickOrderRefNo(String orderno){
		/*String ordertext= orderrefno.getText().trim();
		System.out.println("ordertext is"+ordertext);
		if (ordertext.equalsIgnoreCase(orderno)){
			orderrefno.click();
			TestUtil.longWait();
		}}*/
		
		for (int j=1;j<10;j++) {
            String app = getDriver().findElement(By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr[" + j + "]/td[1]")).getText().trim();
            System.out.println(app);
            if (app.equalsIgnoreCase(orderno.trim())) {
               // driver.findElement(By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr["+j+"]/td[1]/a")).click();
            	//driver.findElement(By.xpath("(//tbody/tr/td)[6]/a[@class='link-button']")).click();
            	getDriver().findElement(By.xpath("(//tbody/tr/td)[7]/a[@title='Reorder']")).click();
            	TestUtil.longWait();
            	break;
             
               }}
            //TestUtil.mediumWait();
		PlusIcon.click();
		TestUtil.mediumWait();
		continueshopping.click();
		TestUtil.mediumWait();
           /* JavascriptExecutor js= (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,10000)");
            */
            
        }
	
public void clickDetailsButton(String orderno){
	myaccount.click();
	TestUtil.shortWait();
	orderaccounthistory.click();
	TestUtil.longWait();
	String ordertext= orderrefno.getText().trim();
	System.out.println("ordertext is"+ordertext);
	if (ordertext.equalsIgnoreCase(orderno)){
		details.click();
		TestUtil.longWait();
	}}
	
	public void clickPDF(String orderno){
		
		String ordertext= orderrefno.getText().trim();
		System.out.println("ordertext is"+ordertext);
		if (ordertext.equalsIgnoreCase(orderno)){
			pdf.click();
			TestUtil.longWait();
	}}
		
		public void reorder(String orderno){
			
			myaccount.click();
			TestUtil.shortWait();
			orderaccounthistory.click();
			TestUtil.shortWait();
			reorder.click();
			TestUtil.mediumWait();
			PlusIcon.click();
			TestUtil.mediumWait();
//			continueshopping.click();
//			TestUtil.mediumWait();
		}

		
		public void checkWishList(){
			myaccount.click();
			TestUtil.shortWait();
			MyWishLists.click();
			TestUtil.shortWait();
			myWishListView.click();
			TestUtil.shortWait();
			wishlistQuantity.clear();
			wishlistQuantity.sendKeys("2");
			TestUtil.mediumWait();
			//wishlistPriority.clear();
			Select select = new Select(wishlistPriority);
			select.selectByIndex(1);
			TestUtil.mediumWait();
			WishListSave.click();
			TestUtil.mediumWait();
		}
		
		public boolean OrdersSortByDate(){
			myaccount.click();
			TestUtil.shortWait();
			orderaccounthistory.click();
			TestUtil.mediumWait();
			orderSortbyDate.click();
			TestUtil.shortWait();
			orderSortbyDate.click();
			TestUtil.shortWait();
			orderrefno.click();
			TestUtil.mediumWait();
			return detailsPageheader.isDisplayed();
		}
		
		public boolean ordersSortByAmount(){
			
			myaccount.click();
			TestUtil.shortWait();
			orderaccounthistory.click();
			TestUtil.mediumWait();
			orderSortbyDate.click();
			TestUtil.shortWait();
			orderSortByAmount.click();
			TestUtil.shortWait();
			orderrefno.click();
			TestUtil.mediumWait();
			return detailsPageheader.isDisplayed();
		}
}
