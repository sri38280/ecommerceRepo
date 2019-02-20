package com.qa.ecommerce.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ecommerce.base.TestBase;
import com.qa.ecommerce.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[@class='account']")
	WebElement myaccount;
	
	@FindBy(xpath="//a[@title='Manage my personal information']")
	WebElement PersonalInfo;

	@FindBy(xpath="//a[@title='My addresses']")
	WebElement myAddresses;
	
	@FindBy(xpath="//a[@class='sf-with-ul']")
	WebElement women;
	
	@FindBy(xpath="(//a[@title='Dresses'])[2]")
	WebElement dresses;
	
	@FindBy(linkText="Summer Dresses")
	WebElement summerdresses;
	
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	WebElement tshirts;
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement FadedShortSleeveTshirts;
	
	@FindBy(xpath="//a[@title='Add to cart']")
	WebElement addtocartshirt;
	
	@FindBy(xpath="(//h2[text()])[1]")
	WebElement SuccessfullyAddedtoCart;
	
	@FindBy(id="search_query_top")
	WebElement SearchBox;
	////*[@id="categories_block_left"]/div/ul/li[1]/a
	
	@FindBy(xpath="//button[@name='submit_search']")
	WebElement submitSearch;
	
	@FindBy(xpath="//select[@id='selectProductSort']")
	WebElement sortBy;
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactus;
	
	@FindBy(xpath="//span[@class='available-now']")
	WebElement InStock;
	
	@FindBy(xpath="//form[@class='compare-form']")
	WebElement compare;
	
	@FindBy(xpath="//img[@title='Printed Summer Dress']")
	WebElement PrintedSummerDress;
	
	@FindBy(xpath="//img[@title='Printed Chiffon Dress']")
	WebElement PrintedChiffonDress;
	
	@FindBy(xpath="(//a[@class='add_to_compare' and text()='Add to Compare'])[1]")
	WebElement addToCompare1;
	
	@FindBy(xpath="(//a[@class='add_to_compare' and text()='Add to Compare'])[2]")
	WebElement addToCompare2;
	
	@FindBy(xpath="//* [@data-id-product='7'] /span ")
	WebElement addtocart1;
	
	@FindBy(xpath="//p[@id='add_to_cart']")
	WebElement addToCart;
	
	@FindBy(xpath="(//a[@title='View'])[1]")
	WebElement view1;
	
	@FindBy(xpath="(//a[@title='View'])[2]")
	WebElement view2;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement ContinueShopping;
	
	@FindBy(xpath="//* [@class='ajax_block_product comparison_infos product-block product-7' ]//div[@class='prices-container']")
	WebElement pricescontainer7;
	
	@FindBy(xpath="//* [@class='ajax_block_product comparison_infos product-block product-6' ]//div[@class='prices-container']")
	WebElement pricescontainer6;
	
	@FindBy(xpath="//td[@class='ajax_block_product comparison_infos product-block product-7']//span[text()='View']")
	WebElement View7;
	
	@FindBy(xpath="//td[@class='ajax_block_product comparison_infos product-block product-6']//span[text()='View']")
	WebElement View6;
	
		
	/*public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}*/
	public HomePage(){
		//this.driver = driver;
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifyTShirtsAddtoCart(){
		women.click();
		TestUtil.mediumWait();
		tshirts.click();
		TestUtil.mediumWait();
		Actions action = new Actions(getDriver());
		action.moveToElement(FadedShortSleeveTshirts).moveToElement(addtocartshirt).click().build().perform();
		TestUtil.mediumWait();
		return SuccessfullyAddedtoCart.isDisplayed();
	}
	
	public WomenPage GotoWomenPage(){
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(women));
		Actions action= new Actions(getDriver());
		action.moveToElement(women).click().build().perform();
		
		return new WomenPage();
		
	}
	
	public DressesPage GotoDressesPage(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(dresses));
		Actions action= new Actions(getDriver());
		action.moveToElement(dresses).click().build().perform();
		
		return new DressesPage();
		
	}
	
	public ContactusPage GoToContactUsPage(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(contactus));
		contactus.click();
		return new ContactusPage();
	}
	
	public MyAccountPage GotoMyAccountPage(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(myaccount));
		myaccount.click();
		return new MyAccountPage();
	}
	
	public AddressesPage GotoMyAddress(){
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(myAddresses));
		myAddresses.click();
		return new AddressesPage();
	}
	
	public IdentityPage GotoIndentity(){
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo));
		PersonalInfo.click();
		return new IdentityPage();
	}
	
public MyOrderPage GotoMyStore(){
		
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo));
		PersonalInfo.click();*/
		return new MyOrderPage();
	}
	

public SearchPage GotoSearch(){
	
	/*WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.elementToBeClickable(PersonalInfo));
	PersonalInfo.click();*/
	return new SearchPage();
}
	public boolean VerifyDresses(){
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(dresses));*/
		return dresses.isDisplayed();
	}
	public boolean VerifyWomen(){
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(women));
*/		return women.isDisplayed();
	}
	public boolean VerifyTshirts(){
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(tshirts));*/
		return tshirts.isDisplayed();
	}
	
	
	/*public boolean verifysummerdresses(){
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(dresses));
		return summerdresses.isDisplayed();
	}*/
	
	public String verifyPageTitle(){
		return getDriver().getTitle();
	}
	
	public String verifycurrentUrl(){
		return getDriver().getCurrentUrl();
	}
	
	public boolean verifySearch(){
		
		SearchBox.sendKeys("Printed Chiffon Dress");
		TestUtil.shortWait();
		submitSearch.click();
		TestUtil.longWait();
		Select select = new Select(sortBy);
		select.selectByVisibleText("Price: Lowest first");
		TestUtil.longWait();
			
		return InStock.isDisplayed();
	}

	public String verifyCompare(){
		SearchBox.sendKeys("Printed Chiffon Dress");
		TestUtil.shortWait();
		submitSearch.click();
		TestUtil.mediumWait();
		Select select = new Select(sortBy);
		select.selectByVisibleText("Price: Lowest first");
		TestUtil.mediumWait();
		Actions action = new Actions(getDriver());
		
		action.moveToElement(PrintedChiffonDress).moveToElement(addToCompare1).click().build().perform();
		TestUtil.longWait();
		action.moveToElement(PrintedSummerDress).moveToElement(addToCompare2).click().build().perform();
			
		TestUtil.longWait();
		compare.click();
		TestUtil.mediumWait();
		view2.click();
		TestUtil.mediumWait();
		addToCart.click();
		TestUtil.mediumWait();
		ContinueShopping.click();
		TestUtil.mediumWait();
		
		return getDriver().getTitle();
	}
	
	public void lowestpriceSelection(){
		
		SearchBox.sendKeys("Printed Chiffon Dress");
		TestUtil.shortWait();
		submitSearch.click();
		TestUtil.mediumWait();;
		Select select = new Select(sortBy);
		select.selectByVisibleText("Price: Lowest first");
		TestUtil.mediumWait();;
		Actions action = new Actions(getDriver());
		action.moveToElement(PrintedSummerDress).moveToElement(addToCompare2).click().build().perform();
		TestUtil.mediumWait();
		
		action.moveToElement(PrintedChiffonDress).moveToElement(addToCompare1).click().build().perform();
		TestUtil.mediumWait();
		/*addToCompare.click();
		TestUtil.mediumWait()*/;
		//addToCompare.click();
		//TestUtil.mediumWait();
		compare.click();
		TestUtil.mediumWait();
		
	String price6 =pricescontainer6.getText();
	System.out.println("price6: " + price6);
	double price6Actual=Double.parseDouble(price6.substring(1,6));
	System.out.println("Price6 Actual: "+price6Actual);
	String price7 =pricescontainer7.getText();
	System.out.println("price7: " + price7);
	double price7Actual= Double.parseDouble(price7.substring(1,6));
	System.out.println("Price 7 Actual:"+ price7Actual);
	//addtocart1.click();
	if (price6Actual<price7Actual){
		
		View6.click();
		 
	  }else{
		 View7.click();
	  }
	}
	public void verifyBrokenLinks(String homePage){
	    //String homePage = "http://automationpractice.com/index.php";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
      //  driver = new ChromeDriver();
        
        //driver.manage().window().maximize();
        
        getDriver().get(homePage);
        
        List<WebElement> links = getDriver().findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
          //  System.out.println(url);
        
            if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
      //  driver.quit();

    }
	}

