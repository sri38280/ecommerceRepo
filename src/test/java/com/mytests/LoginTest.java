package com.mytests;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
		
		WebDriver driver;
		Logger log = Logger.getLogger(LoginTest.class);
		public final String username = "naveenanimation20@gmail.com";
		public final String password = "Test@1234";
		public final String url = "https://www.hubspot.com/login";
		
		public final String loginPageTitle_Expected = "HubSpot Login";
		
		
		@BeforeMethod
		public void setup(){
			log.info("****************************** Starting test cases execution  *****************************************");

			//System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Downloads/geckodriver");	
			driver = new ChromeDriver(); 
			log.info("launching chrome broswer");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			log.info("entering application URL......."+ url);
			driver.get(url);
			log.warn("Hey this just a warning message");
			log.fatal("hey this is just fatal error message");
			log.debug("this is debug message");
		}
		
		@Test(priority=1)
		public void hubSpotTitleTest(){
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** hub spot TitleTest *****************************************");
			String title = driver.getTitle();
			log.info("actual login page title is--->"+title);
			log.info("expected login page title is--->"+loginPageTitle_Expected);
			
			Assert.assertEquals(title, loginPageTitle_Expected);
			
			log.info("****************************** ending test case *****************************************");
			log.info("****************************** hubSpotTitleTest ended *****************************************");

		}
		
		@Test(priority=2)
		public void hubSpotLoginTest(){
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** hubSpotLoginTest *****************************************");

			log.info("app user name is: "+ username);
			log.info("app password is: "+ password);

			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("loginBtn")).click();
			
			log.info("****************************** ending test case *****************************************");
			log.info("****************************** hubSpotLoginTest ended *****************************************");

		}
		
		

		@AfterMethod
		public void tearDown(){
			driver.quit();
			log.info("****************************** Browser is closed *****************************************");		
		}
		
		
		
		
		
		
}
