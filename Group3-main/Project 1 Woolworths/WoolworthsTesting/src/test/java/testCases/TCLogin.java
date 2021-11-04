package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.Constants;
import constants.Excel;
import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.RegistrationPage;




@Test
public class TCLogin {
	
	
static Excel excelUtils = new Excel();
    
    
static String excelFilePath =Constants.Path_TestData+Constants.excelFilePath;
	 public String baseUrl = "https://www.woolworths.co.za/";
		String driverpath = "C:\\selenium\\chromedriver.exe";
	    public WebDriver driver;
	    
	    
	    @BeforeTest // Open Chrome browser and locate Url and maximize browser
	    public void launch() {
	    	
	   	 System.setProperty("webdriver.chrome.driver", driverpath);
	     driver = new ChromeDriver();
	     driver.get(baseUrl); 
	     driver.manage().window().maximize();
	     driver.findElement(By.xpath("/html/body/div[3]/div/a")).click();
	     
	    }



@Test (priority = 0) // Test registration page 

public void a() throws IOException, InterruptedException {
	
	  //Creating object of home page
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);
	RegistrationPage register = new RegistrationPage(driver);
	//Click on Login button
			home.clickLogin();
			home.clickRegister();
			
			excelUtils.setExcelFile(excelFilePath,"Sheet1");
			
			for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
	        {
	        	

	        	
				register.title(excelUtils.getCellData(i,0));
				register.firstName(excelUtils.getCellData(i,1));
				register.lastName(excelUtils.getCellData(i,2));
				register.email(excelUtils.getCellData(i,3));
				register.confirmEmail(excelUtils.getCellData(i,4));
				register.password(excelUtils.getCellData(i,5));
				register.confirmPassword(excelUtils.getCellData(i,6));
				register.contact(excelUtils.getCellData(i,7));
	         	Thread.sleep(1000);
	         	
	         	
				//Click on Register button
				register.clickRegister();
	        	        	

				Thread.sleep(1000);
	         	
	             
	             WebElement errormessage = driver.findElement(By.xpath("//span[@class='form-field__msg form-field__msg--error']"));
	             
	            
	             if (errormessage.isDisplayed() ) {
	             	
	             	excelUtils.setCellValue(i,9,"PASS",excelFilePath);
	             } else {
	                 
	                 excelUtils.setCellValue(i,9,"FAIL",excelFilePath);
	             }

	        	          
			
	        }
	
		}

@Test (priority = 1) // test login page
public void b() throws IOException, InterruptedException {

	  //Creating object of home page
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);
	
	RegistrationPage register = new RegistrationPage(driver);
	
	

	//Click on Login button
	
			register.clickLogin();
		
			
			excelUtils.setExcelFile(excelFilePath,"Sheet2");
			
			for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
	        {
	        	Thread.sleep(1000);
	        	
	        	login.enterUsername(excelUtils.getCellData(i,0));
	        	
				login.enterPassword(excelUtils.getCellData(i,1));
	        	
	        	
				//Click on login button
				login.clickLogin();
	        	

	        	 

	        	Thread.sleep(5000);
	        	         	
	        	WebElement errormsg = driver.findElement(By.xpath("//div[@class='text-small message message--error']"));
	        	
	        	Thread.sleep(1000);
	        	 if (errormsg.isDisplayed() ) {
	              	
	              	excelUtils.setCellValue(i,4,"PASS",excelFilePath);
	              } else {
	                  
	                  excelUtils.setCellValue(i,4,"FAIL",excelFilePath);
	              }

	        	          
			
	        }
	
		}

@Test (priority= 2) // Test login with correct data
public void c() throws IOException, InterruptedException {

	  //Creating object of home page
	HomePage home = new HomePage(driver);
	LoginPage login = new LoginPage(driver);
	
	RegistrationPage register = new RegistrationPage(driver);
	
	

		
			
			excelUtils.setExcelFile(excelFilePath,"Sheet3");
			
			for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
	        {
	        	Thread.sleep(1000);
	        	
	        	login.enterUsername(excelUtils.getCellData(i,0));
	        	
				login.enterPassword(excelUtils.getCellData(i,1));
	        	
	        	
				//Click on login button
				login.clickLogin();
	        	

	        	 	        	
	        	          
			
	        }
	
		}


@Test (priority = 3) // Search item, select and add to cart
public void d() throws IOException, InterruptedException {

	  //Creating object of home page
	LoggedInPage page = new LoggedInPage(driver);
	Thread.sleep(3000);
	page.search("dress");
	Thread.sleep(3000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3250)", "");
	Thread.sleep(3000);	
			
	js.executeScript("window.scrollBy(-0,1250)", "");
	Thread.sleep(3000);	
	
	
	page.clickSelectDress();
	Thread.sleep(3000);
//	page.clickSelectColor();
//	Thread.sleep(3000);
	
	js.executeScript("window.scrollBy(0,2250)", "");
//	Thread.sleep(3000);
//	page.clickSelectSize();
	Thread.sleep(3000);
	page.clickaddtoCart();
	Thread.sleep(3000);
	
	page.clickViewCart();
	
		}




}
