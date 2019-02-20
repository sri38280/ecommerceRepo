package com.qa.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class IdentityPage extends TestBase {
	
	@FindBy(xpath="//a[@title='Manage my personal information']")
	WebElement PersonalInfo;
	
	@FindBy(xpath="//input[@id='old_passwd']")
	WebElement oldPwd;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement newpwd;
	
	@FindBy(xpath="//input[@id='confirmation']")
	WebElement confirmationpwd;
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement SaveIdentity;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement IdentityUpdateSucesslabel;

	public IdentityPage(){
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
		
	}
	
	
	public boolean YourPersonalInfoUpdate(){
		
		PersonalInfo.click();
		TestUtil.shortWait();
		oldPwd.sendKeys("saish@1234");
		newpwd.sendKeys("saish@123");
		confirmationpwd.sendKeys("saish@123");
		SaveIdentity.click();
		TestUtil.mediumWait();
		return IdentityUpdateSucesslabel.isDisplayed();
	}
	
}
