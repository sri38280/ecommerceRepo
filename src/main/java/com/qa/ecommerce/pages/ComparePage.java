package com.qa.ecommerce.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class ComparePage extends TestBase {
	@FindBy(xpath = "//a[@class='account']")
	WebElement myaccount;

	@FindBy(xpath = "//i[@class='icon-list-ol']")
	WebElement orderaccounthistory;

	@FindBy(xpath = "//div[@class='block-center']/descendant::table[1]//tbody/tr[1]/td[1]/a")
	WebElement orderrefno;

	@FindBy(xpath = "(//tbody/tr/td)[7]/a[@class='btn btn-default button button-small']")
	WebElement details;

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	WebElement dresses;

	@FindBy(xpath = "(//a[@title='Short dress, long dress, silk dress, printed dress, you will find the perfect dress for summer.'])[1]")
	WebElement summerdresses;

	@FindBy(xpath = "//a[@title='List']")
	WebElement listBtn;

	@FindBy(xpath = "(//img[@title='Printed Summer Dress'])[2]")
	WebElement PrintedSummerDress2;

	@FindBy(xpath = "(//img[@title='Printed Summer Dress'])[1]")
	WebElement PrintedSummerDress1;

	@FindBy(xpath = "(//img[@title='Printed Chiffon Dress'])[2]")
	WebElement PrintedChiffonDress;

	@FindBy(xpath = "//button[@name='Submit']")
	WebElement addTocart;

	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	WebElement framename1;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement protocheckout;

	/*
	 * @FindBy(xpath="(//a[@title='Proceed to checkout'])[2]") WebElement
	 * protocheckout;
	 */
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement ProceedtoCheckout1;

	@FindBy(xpath = "//select[@id='id_address_delivery']")
	WebElement deliveryaddress;

	@FindBy(xpath = "//button[@name='processAddress']/span[text()='Proceed to checkout']")
	WebElement proceedtocheckout2;

	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement ProceedtoCheckout3;

	@FindBy(id = "cgv")
	WebElement agreeterms;

	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement bankwire;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement iconfirmorder;

	@FindBy(xpath = "(//a[@title='Return to Home'])[1]")
	WebElement returntoHome;

	@FindBy(xpath = "//span[@title='Continue shopping']")
	WebElement continueshopping;

	@FindBy(xpath = "//a[@title='Add to cart']")
	WebElement addtocartshirt;

	@FindBy(xpath = "//div[@class='block-center']/descendant::table[3]//tbody/tr[1]/td[2]")
	WebElement productDescription;

	public ComparePage() {

		//this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	public void oderItems() {
		returntoHome.click();
		TestUtil.shortWait();
		Actions action = new Actions(getDriver());
		action.moveToElement(dresses).click().build().perform();
		TestUtil.shortWait();
		summerdresses.click();
		listBtn.click();
		TestUtil.shortWait();
		PrintedSummerDress1.click();
		TestUtil.shortWait();
		addTocart.click();
		TestUtil.shortWait();
		getDriver().switchTo().frame(framename1);
		TestUtil.mediumWait();
		addTocart.click();
		TestUtil.mediumWait();
		continueshopping.click();
		TestUtil.mediumWait();

		shoppingcart();
	}

	public void clickOrderRefNo(String orderno) {
		/*
		 * String ordertext= orderrefno.getText().trim();
		 * System.out.println("ordertext is"+ordertext); if
		 * (ordertext.equalsIgnoreCase(orderno)){ orderrefno.click();
		 * TestUtil.longWait(); }}
		 */
		myaccount.click();
		TestUtil.shortWait();
		orderaccounthistory.click();
		TestUtil.longWait();
		for (int j = 1; j < 10; j++) {
			String app = getDriver()
					.findElement(
							By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr[" + j + "]/td[1]"))
					.getText().trim();
			System.out.println(app);
			if (app.equalsIgnoreCase(orderno.trim())) {
				getDriver().findElement(
						By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr[" + j + "]/td[1]/a"))
						.click();
				// driver.findElement(By.xpath("(//tbody/tr/td)[6]/a[@class='link-button']")).click();
				// driver.findElement(By.xpath("(//tbody/tr/td)[7]/a[@title='Reorder']")).click();
				TestUtil.longWait();
				break;

			}
		}
		// TestUtil.mediumWait();
		/*
		 * PlusIcon.click(); TestUtil.mediumWait(); continueshopping.click();
		 * TestUtil.mediumWait();
		 */
		/*
		 * JavascriptExecutor js= (JavascriptExecutor)driver;
		 * js.executeScript("window.scrollBy(0,10000)");
		 */

	}

	/*
	 * public void orderItemsLessThan100(double amt){
	 * 
	 * returntoHome.click(); TestUtil.shortWait(); Actions action= new
	 * Actions(driver); action.moveToElement(dresses).click().build().perform();
	 * TestUtil.shortWait(); summerdresses.click(); listBtn.click();
	 * TestUtil.shortWait(); PrintedSummerDress.click(); TestUtil.shortWait();
	 * //BlueBtn.click(); TestUtil.shortWait(); //MoreBtn.click();
	 * TestUtil.shortWait(); driver.switchTo().frame(framename);
	 * plusBtn.click(); plusBtn.click(); plusBtn.click(); plusBtn.click();
	 * plusBtn.click(); TestUtil.shortWait(); Select select = new
	 * Select(sizeBtn); select.selectByValue("2"); //TestUtil.shortWait();
	 * //BlueBtn.click(); //TestUtil.shortWait(); addTocart.click();
	 * TestUtil.shortWait(); continueshopping.click(); TestUtil.shortWait();
	 * viewMyShoppingcart.click(); TestUtil.shortWait(); for (int j=1;j<10;j++)
	 * { String app =
	 * driver.findElement(By.xpath("(//tbody/tr/td)[6]")).getText().trim();
	 * double amount= Double.parseDouble(app.substring(1, 6));
	 * System.out.println(amount); if (amount<=amt) { //
	 * driver.findElement(By.xpath(
	 * "//div[@class='block-center']/descendant::table[1]//tbody/tr["+j+
	 * "]/td[1]/a")).click(); //driver.findElement(By.xpath(
	 * "(//tbody/tr/td)[6]/a[@class='link-button']")).click();
	 * driver.findElement(By.xpath("(//tbody/tr/td)[5]//i[@class='icon-minus']")
	 * ).click(); TestUtil.longWait(); break;
	 * 
	 * }}
	 * 
	 * 
	 * Minus.click(); TestUtil.shortWait(); Minus.click(); TestUtil.shortWait();
	 * Minus.click(); }
	 */
	public void clickDetailsButton(String orderno) {
		myaccount.click();
		TestUtil.shortWait();
		orderaccounthistory.click();
		TestUtil.longWait();
		String ordertext = orderrefno.getText().trim();
		System.out.println("ordertext is" + ordertext);
		if (ordertext.equalsIgnoreCase(orderno)) {
			details.click();
			TestUtil.longWait();
		}
	}

	public void shoppingcart() {

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

	public void productCompare(String orderno1, String orderno2, String orderno3) {

		myaccount.click();
		TestUtil.shortWait();
		orderaccounthistory.click();
		TestUtil.longWait();
		ArrayList<String> orders = new ArrayList<String>();
		
		ArrayList<String> products = new ArrayList<String>();
		// Map<String, String> storeMap= new HashMap<String,String>();

		orders.add(orderno1);
		orders.add(orderno2);
		orders.add(orderno3);
		System.out.println("orders size is::" + orders.size());

		for (int j = 1; j < 10; j++) {
			String order = getDriver()
					.findElement(
							By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr[" + j + "]/td[1]"))
					.getText().trim();
			System.out.println(order);

			for (int i = 0; i < orders.size(); i++){
				if (order.equalsIgnoreCase(orders.get(i).trim())) {
					getDriver().findElement(
							By.xpath("//div[@class='block-center']/descendant::table[1]//tbody/tr[" + j + "]/td[1]/a"))
							.click();
					// driver.findElement(By.xpath("(//tbody/tr/td)[6]/a[@class='link-button']")).click();
					// driver.findElement(By.xpath("(//tbody/tr/td)[7]/a[@title='Reorder']")).click();
					TestUtil.longWait();
					TestUtil.longWait();
					// String product =
					// driver.findElement(By.xpath("//div[@class='block-center']/descendant::table[3]//tbody/tr["+
					// j +"]/td[2]")).getText();
					// ArrayList <String> products = new ArrayList<String>();
					String product = getDriver()
							.findElement(
									By.xpath("//div[@class='block-center']/descendant::table[3]//tbody/tr[1]/td[2]"))
							.getText();
					System.out.println(product);
					products.add(product);
					products.retainAll(products);

					System.out.println(products.size());

					for (int k = 0; k < products.size(); k++) {
						for (int l = k + 1; l < products.size(); l++) {
							if (products.get(k).equals(products.get(l))) {
								System.out.println("duplicate element is::" + products.get(k));
								getDriver().findElement(By.xpath("//span[text()='Reorder']")).click();
								TestUtil.mediumWait();
								getDriver().findElement(By.xpath("//a[@title='Delete']")).click();
								System.out.println("Duplicate Product deleted successfully");
							}
							/*
							 * else { System.out.
							 * println("duplicate element has not been found");
							 * }
							 */

						}
					}
					
					
				
				}
			
			}
			
			}

	}}

