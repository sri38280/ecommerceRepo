package ExcelReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserSignUpDataDriven {
	public static void main(String[] args) {
	
			String sheetName = "signup";

			System.setProperty("webdriver.chrome.driver", "/Users/NaveenKhunteta/Downloads/chromedriver");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.freecrm.com/register/");
			
			Xls_Reader reader = new Xls_Reader("/Users/NaveenKhunteta/Desktop/SignUpFreeCRMTestData.xlsx");
			
			String emailVal = reader.getCellData(sheetName, "email", 3);
			System.out.println(emailVal);
			
			String test = reader.getCellData(sheetName, "password", 6);
			System.out.println(test);
			
			//reader.addSheet("login");
			
//			reader.addColumn(sheetName, "status");
//			reader.setCellData(sheetName, "status", 2, "PASS");		
			if(!reader.isSheetExist("login")){
				reader.addSheet("login");
			}
			
			int rowCount = reader.getRowCount(sheetName);
			System.out.println("total number of rows: " + rowCount);
			
			for(int rowNum=2; rowNum<=rowCount; rowNum++){
				String firstName = reader.getCellData(sheetName, "firstname", rowNum);
				String lastName = reader.getCellData(sheetName, "lastname", rowNum);
				String email = reader.getCellData(sheetName, "email", rowNum);
				String username = reader.getCellData(sheetName, "username", rowNum);
				String password = reader.getCellData(sheetName, "password", rowNum);
				
				System.out.println(firstName + " " + lastName + " " + email + " " + username + " "+ password);
				
				driver.findElement(By.name("first_name")).clear();
				driver.findElement(By.name("first_name")).sendKeys(firstName);
				
				driver.findElement(By.name("surname")).clear();
				driver.findElement(By.name("surname")).sendKeys(lastName);
				
				driver.findElement(By.name("email")).clear();
				driver.findElement(By.name("email")).sendKeys(email);
				
				driver.findElement(By.name("email_confirm")).clear();
				driver.findElement(By.name("email_confirm")).sendKeys(email);
				
				driver.findElement(By.name("username")).clear();
				driver.findElement(By.name("username")).sendKeys(username);
				
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys(password);
				
				driver.findElement(By.name("passwordconfirm")).clear();
				driver.findElement(By.name("passwordconfirm")).sendKeys(password);

				
			}
			
		}

}
