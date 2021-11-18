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
import Pages.Search;

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
    	 
    	 homePage home = new homePage(driver);
    	 
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
    	 home.BacktoLoginBtn();
     }
     @Test (priority = 1)
     public void Login() {
    	 
    	 homePage home = new homePage(driver);
    	
    	 RegistrationPage Login = new RegistrationPage(driver);
    	 
    	 for(int i=5;i<=excelUtils.getRowCountInSheet();i++) {
    		 Login.username(excelUtils.getCellData(i,6));
    		 Login.password(excelUtils.getCellData(i,7));
    		 home.clickLogin();
    		 
    	 }
     }
     
     @Test (priority = 2)
     public void SearchHotel() throws IOException, InterruptedException{
    	 
    	 Search search = new Search(driver);
    	 
    	 excelUtils.setExcelFile(excelSearchData,"Sheet1");
    	 
    	 for(int i=1;i<=excelUtils.getRowCountInSheet();i++) {
    		 
    		 search.location(excelUtils.getCellData(i,0));
    		 search.hotels(excelUtils.getCellData(i,1));
    		 search.roomType(excelUtils.getCellData(i,2));
    		 search.numberOfRooms(excelUtils.getCellData(i,3));
    		 search.checkInDate(excelUtils.getCellData(i,4));
    		 search.checkOutDate(excelUtils.getCellData(i,5));
    		 search.udult(excelUtils.getCellData(i,6));
    		 search.children(excelUtils.getCellData(i,7));
    		 search.search();
    		 Thread.sleep(1000);
    	 }
    	 }
     
}
  
