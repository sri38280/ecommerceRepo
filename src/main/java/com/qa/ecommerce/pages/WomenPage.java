package com.qa.ecommerce.pages;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class WomenPage extends TestBase {

	public String orderrefno;
	
	@FindBy(xpath="(//a[text()='Tops'])[3]")
	WebElement tops;
	@FindBy(xpath="(//a[@title='T-shirts'])[3]")
	WebElement tshirts;
	
	@FindBy(id="layered_id_attribute_group_3")
	WebElement largecheckBox;
	
	@FindBy(id="layered_id_attribute_group_14")
	WebElement BlueColorBox;
	
	@FindBy(id="layered_id_feature_11")
	WebElement StyleCasualBox;
	
	@FindBy(xpath="//a[@title='View']")
	WebElement MoreLink;
	
	@FindBy(xpath="//a[@class='open-comment-form']")
	WebElement WriteAReview;
	
	@FindBy(xpath="//input[@id='comment_title']")
	WebElement ReviewTitle;
	
	@FindBy(id="content")
	WebElement Content;
	
	@FindBy(id="submitNewMessage")
	WebElement submitNewMessage;
	
	@FindBy(xpath="//button[@type='submit']/span[text()='OK']")
	WebElement newCommentOK;
	
	@FindBy(xpath="//span[@class='available-now']")
	WebElement InStock;
	
	@FindBy(xpath="(//a[text()='Dresses'])[4]")
	WebElement dresses;
	
	@FindBy(xpath="//iframe[@class='fancybox-iframe']")
	WebElement framename;
	
	@FindBy(xpath="//a[@class='product_img_link']/img[@class='replace-2x img-responsive']")
	WebElement FadedShortSleeveTshirts;
	
	/*@FindBy(xpath="//button[@name='Submit' and @class='exclusive']/span[text()='Add to cart']")
	WebElement addToCart;*/
	
	@FindBy(xpath="//p[@id='add_to_cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement protocheckout;

	
	/*@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	WebElement ProceedtoCheckout;
*/	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement ProceedtoCheckout1;
	
	@FindBy(xpath="//button[@name='processAddress']/span[text()='Proceed to checkout']")
	WebElement proceedtocheckout2;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement ProceedtoCheckout3;
	
	@FindBy(id="cgv")
	WebElement agreeterms;
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankwire;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement iconfirmorder;
	
	@FindBy(xpath="//div[@class='box']")
	WebElement ordertext;
	
	@FindBy(xpath="(//a[@title='Return to Home'])[1]")
	WebElement returntoHome;
	
	
	public WomenPage(){
		//this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}
	public void scrolldown(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 100);
		wait.until(ExpectedConditions.visibilityOf(tops));
		tops.click();
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		
		int size= getDriver().findElements(By.tagName("frame")).size();
		System.out.println("total frame in page   "+size);
	}
	//Place an order
	public void FadedShortSleeveTshirtsShopCart() throws InterruptedException {
		returntoHome.click();
		
		FadedShortSleeveTshirts.click();
		getDriver().switchTo().frame(framename);
		
		addToCart.click();
		TestUtil.mediumWait();
		/*driver.switchTo().parentFrame()
		driver.switchTo().frame(0);
		for(int i=0; i<size; i++){
			driver.switchTo().frame(i);
			
			
		}*/
		protocheckout.click();	
		//driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		//driver.switchTo().frame(0);
		ProceedtoCheckout1.click();
		//driver.switchTo().frame(0);
		proceedtocheckout2.click();
		//driver.switchTo().frame(0);
		
		agreeterms.click();
		//Thread.sleep(5000);
		ProceedtoCheckout3.click();
		//driver.switchTo().frame(0);
		bankwire.click();
		//driver.switchTo().frame(0);
		iconfirmorder.click();
}
	
	
	public void addtocart(){
		FadedShortSleeveTshirts.click();
		Set<String> handles = getDriver().getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		System.out.println("parent window id is: "+ parentWindowId);
		String childWindowID = it.next();
		System.out.println("child window id is: "+ childWindowID);
		getDriver().switchTo().window(childWindowID);
		//System.out.println("child window title is: "+ driver.getTitle());
		
		//driver.close(); //close the pop up window
		
		//driver.switchTo().window(parentWindowId);
		
		//<iframe id="fancybox-frame1548700218824" name="fancybox-frame1548700218824" class="fancybox-iframe" frameborder="0" vspace="0" hspace="0" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen="" scrolling="auto" src="http://automationpractice.com/index.php?id_product=1&amp;controller=product&amp;content_only=1"></iframe>
		
		/*WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(addToCart));*/
		addToCart.click();
	}
	public boolean verifyTops(){
		return tops.isDisplayed();
	}
	
	public boolean verifyDresses(){
		return dresses.isDisplayed();
	}
	//Retriving order
	public String retrieveOrderNo(){
		String text = ordertext.getText();
		System.out.println(text);
	
	int index =	text.indexOf("reference");
	System.out.println(index);
	String orderrefno =text.substring(216,226).trim();
	
	System.out.println(orderrefno);
	
	return orderrefno;
	/*for ( int i=216; i<226; i++){
		
		System.out.print(text.charAt(216,226));
		*/
		
		
		/*public static String getEmployeeName(String employeeData){
			System.out.println("======= Employee Full Name is =======");
			String orderdetails[] = text.split(" ");
			String employeeFullName = employee[0]+" "+employee[1];
			return employeeFullName;
		}*/
		
		 /*ArrayList<String> list = new ArrayList<String>(); 
		  
	        list.add(Character.toString(text.charAt(i))); 
	        for(int j=0; j<list.size(); j++){
	        	
	        String orderrefno=list.get(j).*/
	        
	        
	        
	     /*  	         	  
	     // Iterator to traverse the list 
	        Iterator iterator = list.iterator(); 
	  
	        //System.out.println("List elements : "); 
	  
	        while (iterator.hasNext()) 
	            System.out.println(iterator.next()); */
		
		
		
			/*StringBuilder out= new StringBuilder();
			String orderrefno=out.append(text.charAt(i)).toString();
			*/
		
		//System.out.print(orderrefno.length());
				//.append(text.charAt(i+1)).append(text.charAt(i+2))
				// .append(text.charAt(i+3)).append(text.charAt(i+4)).toString();
		
		
	}
	
	// selecting catalog
	public boolean catalogSelection(){
		tops.click();
		TestUtil.mediumWait();
		tshirts.click();
		TestUtil.mediumWait();
		largecheckBox.click();
		TestUtil.shortWait();
		BlueColorBox.click();
		TestUtil.shortWait();
		StyleCasualBox.click();
		TestUtil.longWait();
		return InStock.isDisplayed();
		//ReviewTitle.sendKeys("Test");
	}	
	//++++++++++++ Write a review on Product
	public boolean writeaReview(){
		tops.click();
		TestUtil.mediumWait();
		tshirts.click();
		TestUtil.mediumWait();
		
		Actions action = new Actions(getDriver());
		action.moveToElement(FadedShortSleeveTshirts).build().perform();
		MoreLink.click();
		TestUtil.shortWait();
		WriteAReview.click();
		TestUtil.shortWait();
		ReviewTitle.sendKeys("test");
		TestUtil.shortWait();
		Content.sendKeys("test script");
		TestUtil.shortWait();
		submitNewMessage.click();
		TestUtil.shortWait();
		/*Alert al= driver.switchTo().alert();
		al.accept();*/
		newCommentOK.click();
		TestUtil.longWait();
		
		return addToCart.isDisplayed();
	}
}

