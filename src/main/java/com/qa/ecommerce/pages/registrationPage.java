package com.qa.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

import ExcelReader.Xls_Reader;

public class registrationPage extends TestBase{
	
	@FindBy(linkText="Sign in")
	WebElement login;
	
	@FindBy(id="email_create")
	WebElement emailcreate;
	
	@FindBy(xpath="//span/i[@class='icon-user left']")
	WebElement createaccountbtn;
	
	@FindBy(id="customer_firstname")
	WebElement firstname;
	
	@FindBy( id= "customer_lastname")
	WebElement lastname;
	
	@FindBy( id="email")
	WebElement emailid;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="firstname")
	WebElement addFName;
	
	@FindBy(id="lastname")
	WebElement addltName;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city" )
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement mobile;
	
	@FindBy(id="alias")
	WebElement aliasaddress;
	
	@FindBy(xpath="//span[contains(text(), 'Register')]")
	WebElement register;
	
	/*@FindBy(xpath="//div[@class='account_creation']/h3[@class='page-subheading' and text()='Your personal information']")
	WebElement personalInfo;*/
	
	@FindBy(xpath="//h1[@class='page-heading']")
	WebElement createaccount;
	
	@FindBy(xpath="//form[@id='account-creation_form']//h3[@class='page-subheading'][1]")
	WebElement personalInfo;
	
	@FindBy(xpath="(//form[@id='account-creation_form']//h3[@class='page-subheading'])[2]")
	WebElement youraddress;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement signOutBtn;

	
	public registrationPage(){
		//this.driver= driver;
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public String verifyPageTitle(){
		return getDriver().getTitle();
	}
	
	public void selectstatename(String st){
		Select ctrystate = new Select(state);
		ctrystate.selectByVisibleText(st);
		
	}
	
	public void selectcountryname(String ctry){
		
		Select Couny = new Select(country);
		Couny.selectByVisibleText(ctry);
	}
	
	public void verifyPersonalInfoLabel(){
		
		
	}
	
	public void gotoregnpage(String emailadd){
		
		login.click();
		emailcreate.sendKeys(emailadd);
		createaccountbtn.click();
		
	}
	
/*	public void regn(String fn, String ln, String email, String pwd, String addfn, String addln, String add1, String cityadd,String stateadd, String zipcode, String countyadd,String mobileno, String aliasadd){
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		//emailid.sendKeys(email);
		password.sendKeys(pwd);
		addFName.sendKeys(addfn);
		addltName.sendKeys(addln);
		address1.sendKeys(add1);
		city.sendKeys(cityadd);
		state.sendKeys(stateadd);
		postcode.sendKeys(zipcode);
		country.sendKeys(countyadd);
		mobile.sendKeys(mobileno);
		aliasaddress.sendKeys(aliasadd);
		
		register.click();
		//return new MyAccountPage(driver);
		
	}*/
	
	public void regn(){
		String sheetName = "Sheet1";
		//String sheetName1="createaccount";

		//System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		//driver.get("http://automationpractice.com/index.php");
		
		Xls_Reader reader = new Xls_Reader("C:/Users/sujan/workspace/E-Commerce/src/main/java/com/qa/ecommerce/testdata/ecommercetestdata.xlsx");
		/*int rowCount1 = reader.getRowCount(sheetName1);
		System.out.println("total number of rows: " + rowCount1);
		for(int rowNum1=2; rowNum1<=rowCount1; rowNum1++){
		String emailVal = reader.getCellData(sheetName1, "email", rowNum1);
		System.out.println(emailVal);
		*/
		/*login.click();
		email.clear();
		email.sendKeys(emailVal);
		createaccountbtn.click();*/

		//reader.addSheet("login");
		
//		reader.addColumn(sheetName, "status");
//		reader.setCellData(sheetName, "status", 2, "PASS");		
	/*if(!reader.isSheetExist("Sheet1")){
			reader.addSheet("Sheet1");
		}*/
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total number of rows: " + rowCount);
		
		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String firstName = reader.getCellData(sheetName, "firstname", rowNum);
			String lastName = reader.getCellData(sheetName, "lastname", rowNum);
			String email = reader.getCellData(sheetName, "email", rowNum);
			String password1 = reader.getCellData(sheetName, "password", rowNum);
			String addfirstname = reader.getCellData(sheetName, "addressfirstname", rowNum);
			String addlastname = reader.getCellData(sheetName, "addresslastname", rowNum);
			String address = reader.getCellData(sheetName, "address", rowNum);
			String city1 = reader.getCellData(sheetName, "city", rowNum);
			String state1 = reader.getCellData(sheetName, "state", rowNum);
			String zipcode = reader.getCellData(sheetName, "zipcode", rowNum);
			String country1 = reader.getCellData(sheetName, "country", rowNum);
			String mobile1 = reader.getCellData(sheetName, "mobile", rowNum);
			String alias1 = reader.getCellData(sheetName, "alias", rowNum);
			
			
			System.out.println(firstName + " " + lastName + " " + email + " " + password1 + " "+ addfirstname +" " + addlastname +" "+address+ " "+city1+" " + state1 + " " +zipcode+" "+country1+ " "+mobile1+ " "+ alias1);
			TestUtil.longWait();
			login.click();
			emailcreate.clear();
			emailcreate.sendKeys(email);
			createaccountbtn.click();
			TestUtil.longWait();
			firstname.clear();
			firstname.sendKeys(firstName);
			TestUtil.shortWait();
			lastname.clear();
			lastname.sendKeys(lastName);
			//emailid.sendKeys(email);
			
			password.clear();
			password.sendKeys(password1);
			TestUtil.shortWait();
			//addFName.sendKeys(addfirstname);
			//TestUtil.shortWait();
			//addltName.sendKeys(addlastname);
			//TestUtil.shortWait();
			address1.clear();
			address1.sendKeys(address);
			TestUtil.shortWait();
			city.clear();
			city.sendKeys(city1);
			TestUtil.shortWait();
			
			state.sendKeys(state1);
			TestUtil.shortWait();
			postcode.clear();
			postcode.sendKeys(zipcode);
			TestUtil.shortWait();
			
			country.sendKeys(country1);
			TestUtil.shortWait();
			mobile.clear();
			mobile.sendKeys(mobile1);
			TestUtil.shortWait();
			aliasaddress.clear();
			aliasaddress.sendKeys(alias1);
			
			register.click();
			TestUtil.mediumWait();
			signOutBtn.click();
		}		}
	
	
	public boolean verifyCreateAccountlInfo(){
		return createaccount.isDisplayed();
	}

	public boolean verifyPersonalInfo(){
		
		return personalInfo.isDisplayed();
	}
	
	public boolean verifyAddress(){
		
		return youraddress.isDisplayed();
	}
	
	
}
