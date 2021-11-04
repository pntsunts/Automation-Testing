package Woolworths.WoolworthsTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		
		
		
		String baseUrl = "https://zensar.taleo.net/careersection/iam/accessmanagement/login.jsf?lang=en&redirectionURI=https%3A%2F%2Fzensar.taleo.net%2Fcareersection%2Fzen%2Bind%2Bexternal%2Bcareer%2Bportal%2Fjobdetail.ftl%3Fpostdata%3D%24M_LlDV4yAsAut0m1Tm2RLw%26lang%3Den%26ftlcompclass%3DAddRequisitionToCartAction&TARGET=https%3A%2F%2Fzensar.taleo.net%2Fcareersection%2Fzen%2Bind%2Bexternal%2Bcareer%2Bportal%2Fjobdetail.ftl%3Fpostdata%3D%24M_LlDV4yAsAut0m1Tm2RLw%26lang%3Den%26ftlcompclass%3DAddRequisitionToCartAction";
      
        String actualTitle = "";

 

        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);

 

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        System.out.println(actualTitle);
        
        driver.findElement(By.id("dialogTemplate-dialogForm-login-name1")).sendKeys("Hello im a new user");

       

	}

}
