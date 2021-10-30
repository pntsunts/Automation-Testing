package register;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Constants;
import utils.ExcelUtilities;

public class regi {
    
	
    static ExcelUtilities excelUtils = new ExcelUtilities();
    
    
    static String excelFilePath =Constants.TestData;
    
  //  public String baseUrl = "https://www.woolworths.co.za/";
    public String baseUrl = Constants.URLine;
	String driverpath = "C:\\chromedriver.exe";
    public WebDriver driver;
        

    @BeforeTest
    public void launch() throws InterruptedException {
    	
   	 System.setProperty("webdriver.chrome.driver", driverpath);
     driver = new ChromeDriver();
     
     driver.manage().window().maximize();
     
     Thread.sleep(1000);
     
     driver.get(baseUrl); 
    	

	     WebElement login=driver.findElement(By.xpath("/html/body/div[1]/div/header/div[2]/div/section[2]/nav/ul/li[1]/span/strong"));
		  login.click();
	  
    	  WebElement registration=driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/form/div[4]/span[2]/a"));
    	  registration.click();
    	  
    	 
	}
    
    
    @Test (priority = 0)
    public void Registration() throws IOException, InterruptedException {
    	
    	 WebElement cookies = driver.findElement(By.xpath("/html/body/div[3]/div/a"));
         cookies.click();
         Thread.sleep(1000);
         
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

       
         for(int i=9;i<=excelUtils.getRowCountInSheet();i++)
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
         
       @Test (priority = 1)
        public void Login() throws InterruptedException, IOException {
    	   
    	   WebElement login=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/main/div/article/div[2]/aside/section[1]/a"));
    	   login.click();
    	   
    	   WebElement email=driver.findElement(By.id("fldEmailAddressSml"));
           WebElement password=driver.findElement(By.id("fldPasswordSml"));
           WebElement submitBtn=driver.findElement(By.id("login"));
           WebElement search=driver.findElement(By.id("fldSearch"));
           
           excelUtils.setExcelFile(excelFilePath,"Sheet1");
           
           for(int i=9;i<=excelUtils.getRowCountInSheet();i++) {
        	   
        	   Thread.sleep(1000);
               email.clear();
               email.sendKeys(excelUtils.getCellData(i,3));
               
               password.clear();
               Thread.sleep(1000);
               password.sendKeys(excelUtils.getCellData(i,5));
               
               submitBtn.click();
               Thread.sleep(3000);
               
           }
       }
       
       @Test (priority = 2)
       public void Search() throws InterruptedException, IOException {
    	   Thread.sleep(3000);
    	   WebElement search=driver.findElement(By.id("fldSearch"));
    	  
//    	   Thread.sleep(3000);
    	   search.sendKeys("dress", Keys.ENTER); 
    	   
    	   Thread.sleep(3000);
    	   
//    	   JavascriptExecutor js = (JavascriptExecutor) driver;
//           js.executeScript("window.scrollBy(0,3500)","");
//           Thread.sleep(3000);
    	   
       }
       
       @Test (priority = 3)
       public void ZaddToCart() throws InterruptedException {
    	   Thread.sleep(3000);
    	   
    	  // WebElement PlusButton =driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[2]/div/div[2]/div[2]/article/div[1]/a/div/img"));
    	   WebElement PButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[2]/div/div[2]/div[5]/article/div[1]/a/div[2]/img"));
    	   Thread.sleep(3000);  
    	   JavascriptExecutor js = (JavascriptExecutor) driver;
    	   js.executeScript("arguments[0].click();", PButton);
    	   Thread.sleep(3000);
    	   
    	   
    	   
       }
       @Test (priority = 4)
       public void Select() throws InterruptedException {
    	   Thread.sleep(3000);
    	   
    	   WebElement SizeButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/ul/li[2]/div"));
    	   WebElement addButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/span"));
    	   Thread.sleep(3000);
    	   SizeButton.click();
    	   Thread.sleep(3000);
    	   addButton.click();
    	   
       }
//    
       
         @AfterTest
         
         public void closeBrowser() throws InterruptedException {
         	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
         	
             //closing the driver
         	Thread.sleep(3000);
           driver.quit();
     	}
                 	
	}