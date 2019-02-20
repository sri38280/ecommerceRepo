package com.qa.ecommerce.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class AddressesPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Update']")
	WebElement update;
	
	@FindBy(xpath="//a[@title='My addresses']")
	WebElement myAddresses;
	
	@FindBy(xpath="//span[text()='Delete']")
	WebElement DeleteBtn;
	
	@FindBy(xpath="//span[text()='Add a new address']")
	WebElement AddNewAddress;
	
	@FindBy(xpath="//h1[text()='My addresses']")
	WebElement myAddressesLabel;
	
	@FindBy(xpath="//span[text()=' Back to your account']")
	WebElement BacktoYourAccount;
	
	@FindBy(xpath="//span[text()=' Home']")
	WebElement Home;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement zipCode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement mobilephone;
	
	@FindBy(xpath= "//input[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath="//button[@id='submitAddress']")
	WebElement Save;
	
	@FindBy(xpath="(//div//strong[@class='dark'])[6]")
	WebElement updatemessagelabel;
	
	@FindBy(xpath="//a[@title='Add an address']")
	WebElement addanaddress;
	
	@FindBy(xpath="//p[@class='alert alert-warning']")
	WebElement addressesnotavailablelabel;
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement Myaddresses;
	
	/*public AddressesPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}*/
	
	public AddressesPage(){
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean UpdateAddress(){
		//myAddresses.click();
		//TestUtil.shortWait();
		update.click();
		TestUtil.shortWait();
		firstName.clear();
		firstName.sendKeys("Tom");
		lastName.clear();
		lastName.sendKeys("Peter");
		address1.clear();
		address1.sendKeys("forest drive");
		city.clear();
		city.sendKeys("StPaul");
		Select select = new Select(state);
		select.selectByIndex(4);
		
		zipCode.clear();
		zipCode.sendKeys("55129");
		
		Select select1 = new Select(country);
		select1.selectByVisibleText("United States");
		
		mobilephone.clear();
		mobilephone.sendKeys("7035980791");
		
		alias.clear();
		alias.sendKeys("10412 Forest Drive5");
		
		Save.click();
		TestUtil.mediumWait();
			
		return updatemessagelabel.isDisplayed();
		
		
		}
	
	public void addaddressNOdeleteBtn(){
				
		if (addressesnotavailablelabel.isDisplayed()){
			
			//myAddresses.click();
			TestUtil.shortWait();//System.out.println("addresses is not available");
			addanaddress.click();
			TestUtil.longWait();
			firstName.clear();
			firstName.sendKeys("Tom");
			lastName.clear();
			lastName.sendKeys("Peter");
			address1.clear();
			address1.sendKeys("forest drive");
			city.clear();
			city.sendKeys("StPaul");
			Select select = new Select(state);
			select.selectByIndex(4);
			
			zipCode.clear();
			zipCode.sendKeys("55129");
			
			Select select1 = new Select(country);
			select1.selectByVisibleText("United States");
			
			mobilephone.clear();
			mobilephone.sendKeys("7035980791");
			
			alias.clear();
			alias.sendKeys("10412 Forest Drive");
			
			Save.click();
			TestUtil.mediumWait();
					
		}
		else {
			deleteaddress();
		}
	
		}
	
	public boolean deleteaddress(){
		
		//myAddresses.click();
		TestUtil.shortWait();
		DeleteBtn.click();
		Alert al= getDriver().switchTo().alert();
		al.accept();
		
		return Myaddresses.isDisplayed();
	}
	
public void addanaddress(){
	//myAddresses.click();
	TestUtil.shortWait();
	addanaddress.click();
	TestUtil.shortWait();
	firstName.clear();
	firstName.sendKeys("Tom");
	lastName.clear();
	lastName.sendKeys("Peter");
	address1.clear();
	address1.sendKeys("forest drive");
	city.clear();
	city.sendKeys("StPaul");
	Select select = new Select(state);
	select.selectByIndex(4);
	
	zipCode.clear();
	zipCode.sendKeys("55129");
	
	Select select1 = new Select(country);
	select1.selectByVisibleText("United States");
	
	mobilephone.clear();
	mobilephone.sendKeys("7035980792");
	
	alias.clear();
	alias.sendKeys("10412 Forest Drive4");
	
	Save.click();
	TestUtil.mediumWait();
		
	
}
}
