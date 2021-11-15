package TestCases;

import java.io.IOException;

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

import Constants.Constants;
import Constants.Excel;
import Pages.homePage;
import Pages.RegistrationPage;

public class mainCase {
    
    static Excel excelUtils = new Excel();
    
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
     
     homePage home = new homePage(driver);
     home.clickRegister();
     
     }
     
     @Test (priority = 0)
     public void Registration() throws IOException, InterruptedException {
    	 
    	 RegistrationPage register = new RegistrationPage(driver);
    	 
    	 excelUtils.setExcelFile(excelFilePath,"Sheet1");
    	 
    	 for(int i=1;i<=excelUtils.getRowCountInSheet();i++) {
    		 
    		 register.username(excelUtils.getCellData(i,0));
    		 register.password(excelUtils.getCellData(i,1));
    		 register.confiPass(excelUtils.getCellData(i,2));
    		 register.fullName(excelUtils.getCellData(i,3));
    		 register.email(excelUtils.getCellData(i,4));
    		 register.captchaText(excelUtils.getCellData(i,5));
    		 register.clickTerms();
    		 register.clickRegister();
    		 Thread.sleep(1000);
    		 
    		 WebElement errormessage = driver.findElement(By.className("reg_error"));
             
             if (errormessage.isDisplayed() ) {
              	
              	excelUtils.setCellValue(i,9,"PASS",excelFilePath);
              } else {
                  
                  excelUtils.setCellValue(i,9,"FAIL",excelFilePath);
              }
    	 }
     }
}
  
