package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator for login button
	By LoginBtn = By.xpath("/html/body/div[1]/div/header/div[2]/div/section[2]/nav/ul/li[1]/span/strong");
	 
	  
	By RegisterBtn = By.xpath("/html/body/div[5]/div/div/div[2]/div/form/div[4]/span[2]/a");
	  
	//Method to click login button
	public void clickLogin() {
		driver.findElement(LoginBtn).click();
	}
	
	public void clickRegister() {
		driver.findElement(RegisterBtn).click();
	}


}
