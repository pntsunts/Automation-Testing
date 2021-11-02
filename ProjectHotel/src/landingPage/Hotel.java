package landingPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtilities;

public class Hotel {
    
    static ExcelUtilities excelUtils = new ExcelUtilities();
    
    static String excelFilePath =Constants.TestData;
    static String excelSearchData =Constants.searchData;
    static String excelBookData = Constants.bookData;
    
    public String baseUrl = Constants.baseUrl;
	String driverpath = "C:\\chromedriver.exe";
    public WebDriver driver;
    
    @BeforeTest
    public void launch() throws InterruptedException {
    	
   	 System.setProperty("webdriver.chrome.driver", driverpath);
     driver = new ChromeDriver();
     
     driver.manage().window().maximize();
     
     Thread.sleep(1000);
     
     driver.get(baseUrl); 
     
     WebElement registration=driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[7]/td/a"));
     registration.click();
    }
    
    @Test (priority = 0)
    public void Registration() throws IOException, InterruptedException {
    	
    	 WebElement username = driver.findElement(By.id("username"));
         WebElement password = driver.findElement(By.id("password"));
         WebElement confirmPass = driver.findElement(By.id("re_password"));
         WebElement fullName = driver.findElement(By.id("full_name"));
         WebElement email = driver.findElement(By.id("email_add"));
         WebElement captchaText =driver.findElement(By.id("captcha-form"));
         WebElement TermsAndConditions =driver.findElement(By.id("tnc_box"));
         WebElement  submitBtn = driver.findElement(By.id("Submit"));
         WebElement  login = driver.findElement(By.xpath("//*[@id=\"register_form\"]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a"));
         
         excelUtils.setExcelFile(excelFilePath,"Sheet1");
         
         for(int i=1;i<=excelUtils.getRowCountInSheet();i++) {
        	 
        	 username.clear();
        	 Thread.sleep(1000);
        	 username.sendKeys(excelUtils.getCellData(i,0));
        	 
        	 password.clear();
        	 Thread.sleep(1000);
        	 password.sendKeys(excelUtils.getCellData(i,1));
        	 
        	 confirmPass.clear();
        	 Thread.sleep(1000);
        	 confirmPass.sendKeys(excelUtils.getCellData(i,2));
        	 
        	 fullName.clear();
        	 Thread.sleep(1000);
        	 fullName.sendKeys(excelUtils.getCellData(i,3));
        	 
        	 email.clear();
        	 Thread.sleep(1000);
        	 email.sendKeys(excelUtils.getCellData(i,4));
        	 
        	 captchaText.clear();
        	 Thread.sleep(1000);
        	 captchaText.sendKeys(excelUtils.getCellData(i,5));
        	 
        	 TermsAndConditions.click();
             submitBtn.click();
             
             WebElement errormessage = driver.findElement(By.className("reg_error"));
             
             if (errormessage.isDisplayed() ) {
              	
              	excelUtils.setCellValue(i,9,"PASS",excelFilePath);
              } else {
                  
                  excelUtils.setCellValue(i,9,"FAIL",excelFilePath);
              }
             
             Thread.sleep(3000);
 	        
    	     File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
    	     FileUtils.copyFile(screenshot1, new File("C:\\Users\\Peter\\Desktop\\sm\\"+"Screen"+"1.png"));
        	 
         }
         login.click();
    	
    }
    
    @Test (priority = 1)
    public void Login() throws IOException, InterruptedException {
    	
    	WebElement username = driver.findElement(By.id("username"));
    	WebElement password = driver.findElement(By.id("password"));
    	WebElement login = driver.findElement(By.id("login"));
    	
    	excelUtils.setExcelFile(excelFilePath,"Sheet1");
    	
    	for(int i=5;i<=excelUtils.getRowCountInSheet();i++) {
    	
	    	username.clear();
	   	    Thread.sleep(1000);
	     	username.sendKeys(excelUtils.getCellData(i,6));
	   	 
	   	    password.clear();
	   	    Thread.sleep(1000);
	    	password.sendKeys(excelUtils.getCellData(i,7));
	    	
	    	login.click();
    	}
    }
    
    @Test (priority = 2)
    public void searchHotel() throws IOException, InterruptedException {
    	
    	WebElement location = driver.findElement(By.id("location")); 
        WebElement hotels = driver.findElement(By.id("hotels")); 
        WebElement roomType = driver.findElement(By.id("room_type")); 
        WebElement numberOfRooms = driver.findElement(By.id("room_nos")); 
        WebElement checkInDate = driver.findElement(By.id("datepick_in")); 
        WebElement checkOutDate = driver.findElement(By.id("datepick_out")); 
        WebElement udult = driver.findElement(By.id("adult_room")); 
        WebElement children = driver.findElement(By.id("child_room")); 
        WebElement search = driver.findElement(By.id("Submit")); 
        
        excelUtils.setExcelFile(excelSearchData,"Sheet1");
        
        for(int i=1;i<=excelUtils.getRowCountInSheet();i++) {
        
	        location.sendKeys(excelUtils.getCellData(i,0));
	        Thread.sleep(1000);
	        
	        hotels.sendKeys(excelUtils.getCellData(i,1));
	        Thread.sleep(1000);
	        
	        roomType.sendKeys(excelUtils.getCellData(i,2));
	        Thread.sleep(1000);
	        
	        numberOfRooms.sendKeys(excelUtils.getCellData(i,3));
	        Thread.sleep(1000);
	        
	        checkInDate.clear();
	        checkInDate.sendKeys(excelUtils.getCellData(i,4));
	        Thread.sleep(1000);
	        checkOutDate.clear();
	        checkOutDate.sendKeys(excelUtils.getCellData(i,5));
	        Thread.sleep(1000);
	        udult.sendKeys(excelUtils.getCellData(i,6));
	        Thread.sleep(1000);
	        children.sendKeys(excelUtils.getCellData(i,7));
	        search.click();
	        
	        WebElement errormessage = driver.findElement(By.className("reg_error"));
            
            if (errormessage.isDisplayed() ) {
             	
             	excelUtils.setCellValue(i,9,"PASS",excelSearchData);
             } else {
                 
                 excelUtils.setCellValue(i,9,"FAIL",excelSearchData);
             }
            
	        
	        Thread.sleep(3000);
        
	        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
	        FileUtils.copyFile(screenshot1, new File("C:\\Users\\Peter\\Desktop\\sm\\"+"Screen"+"1.png"));
        } 
    }
    @Test (priority = 3)
    public void selectHotel() throws InterruptedException {
    	
    	WebElement select = driver.findElement(By.id("radiobutton_0"));
    	WebElement conti = driver.findElement(By.id("continue"));
    	
    	select.click();
    	Thread.sleep(3000);
    	conti.click();
    } 
    
    @Test (priority = 4)
    public void bookHotel() throws IOException, InterruptedException {
    	
    	WebElement firstName = driver.findElement(By.id("first_name")); 
        WebElement lastName = driver.findElement(By.id("last_name")); 
        WebElement billingAdress = driver.findElement(By.id("address")); 
        WebElement creditCardNo = driver.findElement(By.id("cc_num")); 
        WebElement creditCardType = driver.findElement(By.id("cc_type")); 
        WebElement selectMonth = driver.findElement(By.id("cc_exp_month")); 
        WebElement selectYear = driver.findElement(By.id("cc_exp_year"));
        WebElement cvvNumber = driver.findElement(By.id("cc_cvv"));
        WebElement submitBtn = driver.findElement(By.id("book_now"));
        
        excelUtils.setExcelFile(excelBookData,"Sheet1");
        
        for(int i=1;i<=excelUtils.getRowCountInSheet();i++) {
        	
        	firstName.clear();
        	Thread.sleep(1000);
        	firstName.sendKeys(excelUtils.getCellData(i,0));
        	
        	lastName.clear();
        	Thread.sleep(1000);
        	lastName.sendKeys(excelUtils.getCellData(i,1));
        	
        	billingAdress.clear();
        	Thread.sleep(1000);
        	billingAdress.sendKeys(excelUtils.getCellData(i,2));
        	
        	creditCardNo.clear();
        	Thread.sleep(1000);
        	creditCardNo.sendKeys(excelUtils.getCellData(i,3));
        	
        	Thread.sleep(1000);
        	creditCardType.sendKeys(excelUtils.getCellData(i,4));
        	
        	Thread.sleep(1000);
        	selectMonth.sendKeys(excelUtils.getCellData(i,5));
        	
        	Thread.sleep(1000);
        	selectYear.sendKeys(excelUtils.getCellData(i,6));
        	
        	cvvNumber.clear();
        	Thread.sleep(1000);
        	cvvNumber.sendKeys(excelUtils.getCellData(i,7));
        	
        	 submitBtn.click();
        	
       	     WebElement errormessage = driver.findElement(By.className("reg_error"));
             
             if (errormessage.isDisplayed() ) {
              	
              	excelUtils.setCellValue(i,9,"PASS",excelBookData);
              } else {
                  
                  excelUtils.setCellValue(i,9,"FAIL",excelBookData);
              }
             
 	        
 	        Thread.sleep(5000);
         
 	        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
 	        FileUtils.copyFile(screenshot1, new File("C:\\Users\\Peter\\Desktop\\sm\\"+"Screen"+"1.png"));
        }   
    }
    @AfterTest
    
    public void closeBrowser() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
    	
        //closing the driver
    	Thread.sleep(3000);
      driver.quit();
	}
}
    
