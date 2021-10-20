import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataDriven {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 
		  //Create an object of File class to open xls file
	        File file =    new File("C:\\Users\\Peter\\Desktop\\DataMC.xlsx");
	        
	        //Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(file);
	        
	      //creating workbook instance that refers to .xls file
	        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
	        
	        XSSFSheet sheet=wb.getSheet("Sheet1");
	        
	        //get all rows in the sheet
	        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	        
	       //Creating an object of ChromeDriver
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize(); //Maximize web browser
	        
	        driver.get("https://demoqa.com/automation-practice-form");
	        
	        for(int i=1;i<=rowCount;i++) {
	            //Enter the values read from Excel in firstname,lastname,mobile,email,address
	        	WebDriverWait wait = new WebDriverWait(driver, 15);
	        	Thread.sleep(5000);
	        	  WebElement name=driver.findElement(By.id("firstName"));
	        	  wait.until(ExpectedConditions.elementToBeClickable(name)).clear();
	            name.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue()); 
	            Thread.sleep(1000);
	            
	      	  WebElement surname=driver.findElement(By.id("lastName"));
	          wait.until(ExpectedConditions.elementToBeClickable(surname)).clear();
	          surname.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue()); 
	          Thread.sleep(1000);
	            WebElement email=driver.findElement(By.id("userEmail"));
	            wait.until(ExpectedConditions.elementToBeClickable(email)).clear();
	            email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
	            Thread.sleep(1000);
	            WebElement gender=driver.findElement(By.id("gender-radio-1"));
		 
	            WebElement phone=driver.findElement(By.id("userNumber"));
		    	  wait.until(ExpectedConditions.elementToBeClickable(phone)).clear();
		          phone.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue()); 
		          Thread.sleep(1000);
	            
	            WebElement adress=driver.findElement(By.id("currentAddress"));
	            wait.until(ExpectedConditions.elementToBeClickable(adress)).clear();
	            adress.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
	            Thread.sleep(1000);
	      	 
	            //Click on the terms radio button using javascript
	      	   JavascriptExecutor js = (JavascriptExecutor) driver;
        	   js.executeScript("arguments[0].click();", gender);
	            
	           // WebElement submitBtn=driver.findElement(By.id("submit"));
	            WebElement submitBtn=driver.findElement(By.xpath("//*[@id=\"submit\"]"));
	  
	            //Click on submit button
	           // submitBtn.click();
	            js.executeScript("arguments[0].click();", submitBtn);
	            
	            Thread.sleep(1000);
	            //Verify the confirmation message
	            WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
	            
	            

	            //create a new cell in the row at index 9 and 10
	            XSSFCell cell = sheet.getRow(i).createCell(9);
	            XSSFCell cell2 = sheet.getRow(i).createCell(10);
	            
	            //check if confirmation message is displayed
	            if (confirmationMessage.isDisplayed()) {
	                // if the message is displayed , write PASS in the excel shee
	                
	                cell.setCellValue("Positive Test");
	                System.out.println("Positive");
	                cell2.setCellValue("PASS");
	                
	            } else {
	                //if the message is not displayed , write FAIL in the excel sheet
	                cell.setCellValue("Negative");
	                System.out.println("Negative");
	                cell2.setCellValue("Pass");
	                
	                
	            }
	            
	            // Write the data back in the Excel file
	            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Peter\\Desktop\\TestResults.xlsx");
	            wb.write(outputStream);

	          
	            WebElement cl =driver.findElement(By.id("closeLargeModal"));
	            js.executeScript("arguments[0].click();", cl);
	            
	            //wait for page to come back to registration page after close button is clicked
	            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	        }
	        
	        //Close the workbook
	        wb.close();
	        
	        //Quit the driver
	        driver.quit();
	        }

}
