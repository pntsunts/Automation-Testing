package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {
	
WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public LoggedInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator for login button
	By search = By.xpath("/html/body/div[1]/div/header/div[2]/div/section[3]/div/div/form/input[2]");
	 
	  
	By selectDress = By.xpath("/html/body/div[1]/div/div/main/div/div[2]/div[2]/div/div[2]/div[2]/article/div[1]/a/div[2]/img");
	  
	By colorBy = By.xpath("/html/body/div[1]/div/div/main/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/ul/li[2]/img");
	
	By sizeBy = By.xpath("/html/body/div[1]/div/div/main/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/ul/li[2]/div");
	By addToCart = By.xpath("/html/body/div[1]/div/div/main/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/span");
	
	By viewCartBy = By.xpath("/html/body/div[1]/div/header/div[2]/div/section[2]/nav/ul/li[3]/div/a/span");
	//Method to click login button
	public void search(String wsearch) {
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(wsearch,Keys.ENTER);
	}
	
	public void clickSelectDress() {
		driver.findElement(selectDress).click();
	}
//	public void clickSelectColor() {
//		driver.findElement(colorBy).click();
//	}
	public void clickSelectSize() {
		driver.findElement(sizeBy).click();
	}
	public void clickaddtoCart() {
		driver.findElement(addToCart).click();
	}
	public void clickViewCart() {
		driver.findElement(viewCartBy).click();
	}

}
