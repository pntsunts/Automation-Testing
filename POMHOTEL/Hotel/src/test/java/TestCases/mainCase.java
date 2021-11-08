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
    	 homePage home = new homePage(driver);
     }
 
}
  
