package com.qa.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ecommerce.base.TestBase;

public class DressesPage extends TestBase {
	
	@FindBy(xpath="(//a[text()='Casual Dresses'])[4]")
	WebElement casualdresses;
	
	@FindBy(xpath="(//a[text()='Evening Dresses'])[4]")
	WebElement eveningdresses;
	
	@FindBy(xpath="(//a[text()='Summer Dresses'])[4]")
	WebElement summerdresses;
	
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	WebElement tshirts;
	//(//tbody/tr[2]//td)[4]
	//webtable xpath (//tbody/tr//td)[4]


public DressesPage(){
	
	//this.driver = driver;
	PageFactory.initElements(getDriver(), this);
}

public boolean verifyCasualDresses(){
	return casualdresses.isDisplayed();
}

public boolean verifyEveningDresses(){
	
	return eveningdresses.isDisplayed();
}

public boolean verifySummerDresses(){
	
	return summerdresses.isDisplayed();
}


}
