package register;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtilities;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class Registration {
    
	
    static ExcelUtilities excelUtils = new ExcelUtilities();
    
    
    static String excelFilePath =Constants.Path_TestData+Constants.File_TestData;
    
    public String baseUrl = "https://www.woolworths.co.za/";
	String driverpath = "C:\\chromedriver.exe";
    public WebDriver driver;
        

    @BeforeTest
    public void launch() {
    	
   	 System.setProperty("webdriver.chrome.driver", driverpath);
     driver = new ChromeDriver();
     driver.get(baseUrl); 
    	
  
    	

    	  WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div/header/div[2]/div/section[2]/nav/ul/li[1]/span/strong"));
    	  login.click();
    	  
    	  WebElement registration=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/form/div[4]/span[2]/a"));
    	  registration.click();
	}
    
    
    @Test
    public void Registration() throws IOException, InterruptedException {
		
    	 WebElement title=driver.findElement(By.id("fldTitle"));
         WebElement firstName=driver.findElement(By.id("fldFirstName"));
         WebElement lastName=driver.findElement(By.id("fldLastName"));
         WebElement email=driver.findElement(By.id("fldEmailAddress"));
         WebElement confirmEmail=driver.findElement(By.id("fldConfirmEmailAddress"));
         WebElement password=driver.findElement(By.id("fldPassword"));
         WebElement confirmPassword=driver.findElement(By.id("fldConfirmPassword"));
         WebElement contact=driver.findElement(By.id("fldContactNumber"));
         
         WebElement woolworthsCheck=driver.findElement(By.id("fldWoolWorths"));
         WebElement financialCheck=driver.findElement(By.id("fldWoolWorthsFS"));
         WebElement submitBtn=driver.findElement(By.id("fldSubmit"));
         
         excelUtils.setExcelFile(excelFilePath,"Sheet1");

       
         for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
         {
         	Thread.sleep(1000);
         	title.sendKeys(excelUtils.getCellData(i,0));
         	firstName.clear();
         	Thread.sleep(1000);
         	firstName.sendKeys(excelUtils.getCellData(i,1));
         	lastName.clear();
         	Thread.sleep(1000);
         	lastName.sendKeys(excelUtils.getCellData(i,2));
         	Thread.sleep(1000);
         	email.clear();
         	email.sendKeys(excelUtils.getCellData(i,3));
         	confirmEmail.clear();
         	Thread.sleep(1000);
         	confirmEmail.sendKeys(excelUtils.getCellData(i,4));
         	password.clear();
         	Thread.sleep(1000);
         	password.sendKeys(excelUtils.getCellData(i,5));
         	confirmPassword.clear();
         	Thread.sleep(1000);
         	confirmPassword.sendKeys(excelUtils.getCellData(i,6));
         	contact.clear();
         	Thread.sleep(1000);
         	contact.sendKeys(excelUtils.getCellData(i,7));
         	Thread.sleep(1000);
         	
         	JavascriptExecutor js = (JavascriptExecutor) driver;
         	js.executeScript("arguments[0].click();", woolworthsCheck); //Click on the gender radio button using javascript
        
         	Thread.sleep(1000);
         	js.executeScript("arguments[0].click();", financialCheck);
         	
         	js.executeScript("arguments[0].click();", submitBtn);


         
         	Thread.sleep(1000);
         	
             
             WebElement errormessage = driver.findElement(By.xpath("//span[@class='form-field__msg form-field__msg--error']"));
             
            
             if (errormessage.isDisplayed() ) {
             	
             	excelUtils.setCellValue(i,9,"PASS",excelFilePath);
             } else {
                 
                 excelUtils.setCellValue(i,9,"FAIL",excelFilePath);
             }
         }

            
         }
         @AfterTest
         public void closeBrowser() {
         	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
         	
             //closing the driver
             driver.quit();
     	}
                 	
	}
    