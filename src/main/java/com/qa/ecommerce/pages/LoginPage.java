package com.qa.ecommerce.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

import ExcelReader.Xls_Reader;
import TestNGListenerConcept.CustomListener;
@Listeners(CustomListener.class)
public class LoginPage extends TestBase {

	@FindBy(id= "email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//span/i[@class='icon-lock left']")
	WebElement signin;
	
	@FindBy(linkText="Sign in")
	WebElement login;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotpwd;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement signout;
	
	@FindBy(xpath="//a[@title='View my customer account' and @class='account']" )
	WebElement accountName;
	
	@FindBy(xpath="//h1[text()='Authentication']")
	WebElement authenticationlabel;
	
	@FindBy(xpath="//p[text()='There is 1 error']")
	WebElement errormessage;
	
	public LoginPage(){
		
		//this.driver= driver;
		PageFactory.initElements(getDriver(), this);
		
	}
	public String verifyPageTitle(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 100);
		wait.until(ExpectedConditions.visibilityOf(forgotpwd));
		return getDriver().getTitle();
	}
	
	public boolean verifyforgotpwdlink(){
		login.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOf(forgotpwd));
				
		return forgotpwd.isDisplayed();
		
	}
	
	public void clicksigninlink(){
		login.click();
	}
	
	public void loginToAutomationExcel() throws IOException{
		
		String sheetLogin = "LoginStatus";
		
		Xls_Reader readerlogin = new Xls_Reader("C:\\Users\\sujan\\workspace\\E-Commerce\\src\\main\\java\\com\\qa\\ecommerce\\testdata\\LoginStatus.xlsx");
		
		int rowCount = readerlogin.getRowCount(sheetLogin);
		System.out.println("total number of rows: " + rowCount);
		readerlogin.addColumn(sheetLogin, "status");
		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String userName = readerlogin.getCellData(sheetLogin, "username", rowNum);
			String pwd = readerlogin.getCellData(sheetLogin, "Password", rowNum);
			
			login.click();
			username.sendKeys(userName);
			password.sendKeys(pwd);
			signin.click();
			TestUtil.longWait();
			String title = getDriver().getTitle();
			if(title.contains("My account - My Store")){
				readerlogin.setCellData(sheetLogin, "status", rowNum, "PASS");
				signout.click();
				}else
				{
					TestUtil.takeScreenshotAtEndOfTest();
					readerlogin.setCellData(sheetLogin, "status", rowNum, "FAIL");	
				}
			
		}
					
	}
	
	public void loginDataProvider(String un, String pwd) throws IOException{
		login.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signin.click();
		
	String loginURL=getDriver().getCurrentUrl();
		
		/*if(driver.getPageSource().contains("There is 1 error")){
			TestUtil.takeScreenshotAtEndOfTest();
			
		}
	*/
		
		}
	
	public HomePage login(String un, String pwd) {
		login.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signin.click();
		return new HomePage();
		
	}
	
	public void logout(String accname){
		WebDriverWait wait = new WebDriverWait(getDriver(), 50);
		wait.until(ExpectedConditions.elementToBeClickable(signout));
				
		if(accountName.isDisplayed()){
		
			signout.click();
			
		}
		
	}
	
		}
