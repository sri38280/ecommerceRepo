package com.qa.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class ContactusPage extends TestBase {
	
	
	@FindBy(xpath="//select[@id='id_contact']")
	WebElement subheading;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailaddress;
	
	@FindBy(xpath="//select[@name='id_order']")
	WebElement orderreference;
	
	@FindBy(xpath="(//select[@name='id_product'])[1]")
	WebElement products;
	
	@FindBy(xpath="//input[@type='file' and @id='fileUpload']")
	WebElement choosefile;
	
	@FindBy(id="message")
	WebElement message;
	
	@FindBy(xpath= "//button[@id='submitMessage']")
	WebElement submitMessage;
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactus;
	
	@FindBy(xpath="//p[text()='Your message has been successfully sent to our team.']")
	WebElement messeagesentsuccess;
	
	
	public ContactusPage(){
		//this.driver=driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public String verifyContactUsPage(){
		contactus.click();
		return getDriver().getTitle();
		
	}
public void selectDropDownList(WebElement xpath, String value){
		
		
		List <WebElement> list =getDriver().findElements(By.tagName("option"));
		
		for ( int i=0; i<list.size(); i++){
			
		if	(list.get(i).getText().equals(value)){
			list.get(i).click();
			break;
		}
			
		}}
	
	
	public boolean sendmessage(String subhead,String orderref,int prod, String chosefile, String messg) throws InterruptedException {
		
		contactus.click();
		
		Select select = new Select(subheading) ;
		select.selectByVisibleText(subhead);
		TestUtil.shortWait();
		
		Select orderselect = new Select(orderreference) ;
		orderselect.selectByValue(orderref);;
		TestUtil.longWait();
		
		Select productselect = new Select(products);
		
		productselect.selectByIndex(prod);;
		
		choosefile.sendKeys(chosefile);
		
		message.sendKeys(messg);
		
		submitMessage.click();
		
		return messeagesentsuccess.isDisplayed();

		
	}
	

}
