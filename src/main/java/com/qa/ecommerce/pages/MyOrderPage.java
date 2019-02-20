package com.qa.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class MyOrderPage extends TestBase {
	//public String orderrefno;
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	
	WebElement tshirts;
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement FadedShortSleeveTshirts;
	
	@FindBy(xpath="//a[@class='addToWishlist wishlistProd_1']")
	WebElement addToWishList;
	
	@FindBy(xpath="//a[@title='Add to cart']")
	WebElement addtocartshirt;
	
	@FindBy(xpath="//a[@title='Close']")
	WebElement AddWishlistClose;
	//=====================================order items with properties
	
	@FindBy(xpath="(//a[@title='Return to Home'])[1]")
	WebElement returntoHome;
	
	
	@FindBy(xpath="(//a[@title='Women'])[1]")	
	WebElement women;
	
	@FindBy(xpath="(//a[@title='Dresses'])[2]")
	WebElement dresses;
	
	@FindBy(xpath="(//a[@title='Short dress, long dress, silk dress, printed dress, you will find the perfect dress for summer.'])[1]")
	WebElement summerdresses;
	
	@FindBy(xpath="//a[@title='List']")
	WebElement listBtn;
	
	@FindBy(xpath="(//img[@title='Printed Summer Dress'])[2]")
	WebElement PrintedSummerDress;
	
	@FindBy(xpath="//a[@title='View']")
	WebElement MoreBtn;
	
	@FindBy(xpath="//a[@id='color_14']")
	WebElement BlueBtn;
	
	@FindBy(xpath="//i[@class='icon-plus']")
	WebElement plusBtn;
	
	@FindBy(xpath="//select[@id='group_1']")
	WebElement sizeBtn;
	
	@FindBy(xpath="//button[@name='Submit']")
	WebElement addTocart;
	
	@FindBy(xpath="//iframe[@class='fancybox-iframe']")
	WebElement framename;

	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement protocheckout;
	
	/*@FindBy(xpath="(//a[@title='Proceed to checkout'])[2]")
	WebElement protocheckout;
*/
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement ProceedtoCheckout1;
	
	@FindBy(xpath="//select[@id='id_address_delivery']")
	WebElement deliveryaddress;
	
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
	//---------------------------------value<100
	@FindBy(xpath="//span[@class='ajax_block_cart_total']")
	WebElement cartTotal;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement viewMyShoppingcart;
	
	@FindBy (xpath="(//tbody/tr/td)[5]//i[@class='icon-minus']")
	WebElement Minus;
	
	@FindBy(xpath="//input[@class='cart_quantity_input form-control grey']")
	WebElement quantity;
	
	@FindBy(xpath="(//tbody/tr/td)[4]")
	WebElement unitprice;
	
	
	
	
	public MyOrderPage(){
		//this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}
	
	public void AddtoWishList(){
		tshirts.click();
		TestUtil.shortWait();
		Actions action= new Actions(getDriver());
		action.moveToElement(FadedShortSleeveTshirts).moveToElement(addToWishList).click().build().perform();
		TestUtil.shortWait();
		AddWishlistClose.click();
		
	}
	
	public void oderItems(){
		returntoHome.click();
		TestUtil.shortWait();
		Actions action= new Actions(getDriver());
		action.moveToElement(dresses).click().build().perform();
		TestUtil.shortWait();
		summerdresses.click();
		listBtn.click();
		TestUtil.shortWait();
		PrintedSummerDress.click();
		TestUtil.shortWait();
		//BlueBtn.click();
		//TestUtil.shortWait();
		//MoreBtn.click();
		TestUtil.shortWait();
		getDriver().switchTo().frame(framename);
		
		for(int i=0;i<4;i++){
		plusBtn.click();
		}
		TestUtil.shortWait();
		Select select = new Select(sizeBtn);
		select.selectByValue("2");
		//TestUtil.shortWait();
		//BlueBtn.click();
		//TestUtil.shortWait();
		addTocart.click();
		TestUtil.shortWait();
		
		String carttotl= cartTotal.getText();
		System.out.println(carttotl);
		String total= carttotl.substring(1, 7);
		Double TotalActual= Double.parseDouble(total);
		System.out.println(TotalActual);
				
		if (TotalActual>100){
			
			continueshopping.click();
			TestUtil.shortWait();
			viewMyShoppingcart.click();
			TestUtil.shortWait();
			for(int j=0; j<2; j++){
			Minus.click();
			TestUtil.shortWait();
			
			}
			//protocheckout.click();
			//TestUtil.shortWait();
			}
			
			else {
				shoppingcart();
			}
							
			}
		
			
		
	
	/*public void orderItemsLessThan100(double amt){
		
		returntoHome.click();
		TestUtil.shortWait();
		Actions action= new Actions(driver);
		action.moveToElement(dresses).click().build().perform();
		TestUtil.shortWait();
		summerdresses.click();
		listBtn.click();
		TestUtil.shortWait();
		PrintedSummerDress.click();
		TestUtil.shortWait();
		//BlueBtn.click();
		TestUtil.shortWait();
		//MoreBtn.click();
		TestUtil.shortWait();
		driver.switchTo().frame(framename);
		plusBtn.click();
		plusBtn.click();
		plusBtn.click();
		plusBtn.click();
		plusBtn.click();
		TestUtil.shortWait();
		Select select = new Select(sizeBtn);
		select.selectByValue("2");
		//TestUtil.shortWait();
		//BlueBtn.click();
		//TestUtil.shortWait();
		addTocart.click();
		TestUtil.shortWait();
		continueshopping.click();
		TestUtil.shortWait();
		viewMyShoppingcart.click();
		TestUtil.shortWait();
		for (int j=1;j<10;j++) {
            String app = driver.findElement(By.xpath("(//tbody/tr/td)[6]")).getText().trim();
           double amount= Double.parseDouble(app.substring(1, 6));
            System.out.println(amount);
            if (amount<=amt) {
               // driver.findElement(By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr["+j+"]/td[1]/a")).click();
            	//driver.findElement(By.xpath("(//tbody/tr/td)[6]/a[@class='link-button']")).click();
                driver.findElement(By.xpath("(//tbody/tr/td)[5]//i[@class='icon-minus']")).click();
            	TestUtil.longWait();
            	break;
             
               }}
		
			
			Minus.click();
			TestUtil.shortWait();
			Minus.click();
			TestUtil.shortWait();
			Minus.click();
		}*/
		
		
	
		
		
	
	
	public void shoppingcart(){
			
		
		ProceedtoCheckout1.click();
		TestUtil.shortWait();
		Select selectaddress = new Select(deliveryaddress);
		selectaddress.selectByIndex(0);
		TestUtil.mediumWait();
		proceedtocheckout2.click();
		TestUtil.shortWait();
		agreeterms.click();
		TestUtil.shortWait();
		ProceedtoCheckout3.click();
		TestUtil.shortWait();
		bankwire.click();
		TestUtil.shortWait();
		iconfirmorder.click();
		
	}
		
		public String retrieveOrderNo(){
		String text = ordertext.getText();
		System.out.println(text);
		
		int index =	text.indexOf("reference");
		System.out.println(index);
		String orderrefno =text.substring(216,226).trim();
		
		System.out.println(orderrefno);
		
		return orderrefno;
	}
	
	}
