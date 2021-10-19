


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SchoolRegistration {
    public static  void main(String args[]) throws IOException, InterruptedException {
        //set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        

        //Create an object of File class to open xls file
        File file =    new File("C:\\Users\\Peter\\Desktop\\DataX.xlsx");
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        
        //creating a Sheet object
        XSSFSheet sheet=wb.getSheet("TEST_DATA");
        
        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        
       //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //Maximize web browser
        
        //Navigate to the URL
        driver.get("http://group3.dopeidea.co.za/registration.html");


		 
		 
	 	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");  //date format
		Date curDate = new Date();
		String strDate = sdf.format(curDate); //current date
		int fileNumber = 1;
		fileNumber = fileNumber++;
		String fileName = "ScreenShot_" + strDate + fileNumber; // file name name + timestamp
		File newFile = new File(fileName);
		
		 int min = 101010;
         int max = 999999;
		int number = (int)(Math.random()*(max-min+1)+min);
      System.out.println(number);
		File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //take screenshot of Home page
      //  FileUtils.copyFile(screenshot1, new File("C:\\Users\\Ndou\\Desktop\\SchoolRegistration\\Screenshot\\"+newFile + number+".png")); // Copy the file to a location and use 
 
        
        
        //iterate over all the rows in Excel and put data in the form.
        for(int i=1;i<=rowCount;i++) {
            //Enter the values read from Excel in firstname,lastname,mobile,email,address
        	WebDriverWait wait = new WebDriverWait(driver, 15);
        	Thread.sleep(5000);
        	  WebElement name=driver.findElement(By.id("name"));
        	  wait.until(ExpectedConditions.elementToBeClickable(name)).clear();
            name.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue()); 
            Thread.sleep(1000);
      	  WebElement surname=driver.findElement(By.id("surname"));
          wait.until(ExpectedConditions.elementToBeClickable(surname)).clear();
          surname.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue()); 
          Thread.sleep(1000);
    	  WebElement phone=driver.findElement(By.id("phone"));
    	  wait.until(ExpectedConditions.elementToBeClickable(phone)).clear();
          phone.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue()); 
          Thread.sleep(1000);
            WebElement email=driver.findElement(By.id("email"));
            wait.until(ExpectedConditions.elementToBeClickable(email)).clear();
            email.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
            Thread.sleep(1000);
            WebElement password=driver.findElement(By.id("pass"));
            wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
            password.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
            Thread.sleep(1000);
            WebElement password2=driver.findElement(By.id("re_pass"));
            wait.until(ExpectedConditions.elementToBeClickable(password2)).clear();
            password2.sendKeys(sheet.getRow(i).getCell(6).getStringCellValue());
            Thread.sleep(1000);
      	  WebElement address=driver.findElement(By.id("address"));
      	 wait.until(ExpectedConditions.elementToBeClickable(address)).clear();
          address.sendKeys(sheet.getRow(i).getCell(7).getStringCellValue()); 
          Thread.sleep(1000);
            
            //Click on the terms radio button using javascript
        WebElement agreeTerms= driver.findElement(By.id("agree-term"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", agreeTerms);
            Thread.sleep(1000);
            
            WebElement submitBtn=driver.findElement(By.id("signup"));
            //Click on submit button
            submitBtn.click();
            
            Thread.sleep(1000);
            //Verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.xpath("//*[@id=\"thank-you-message\"]"));
            
            

            //create a new cell in the row at index 9 and 10
            XSSFCell cell = sheet.getRow(i).createCell(9);
            XSSFCell cell2 = sheet.getRow(i).createCell(10);
            
            //check if confirmation message is displayed
            if (confirmationMessage.isDisplayed()) {
                // if the message is displayed , write PASS in the excel sheet
            	
            	File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //take screenshot of Home page
               // FileUtils.copyFile(screenshot2, new File("C:\\Users\\Ndou\\Desktop\\SchoolRegistration\\Screenshot\\"+newFile + number+".png")); // Copy the file to a location and use 
         
                
                cell.setCellValue("Positive Test");
                System.out.println("Positive");
                cell2.setCellValue("PASS");
                
            } else {
                //if the message is not displayed , write FAIL in the excel sheet
                cell.setCellValue("Negative");
                System.out.println("Negative");
                cell2.setCellValue("Pass");
                
                File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //take screenshot of Home page
              //  FileUtils.copyFile(screenshot3, new File("C:\\Users\\Ndou\\Desktop\\SchoolRegistration\\Screenshot\\"+newFile + number+".png")); // Copy the file to a location and use 
         
                
            }
            
            // Write the data back in the Excel file
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Peter\\Desktop\\TestResults.xlsx");
            wb.write(outputStream);

          

            
            //wait for page to come back to registration page after close button is clicked
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        }
        
        //Close the workbook
        wb.close();
        
        //Quit the driver
        driver.quit();
        }
}