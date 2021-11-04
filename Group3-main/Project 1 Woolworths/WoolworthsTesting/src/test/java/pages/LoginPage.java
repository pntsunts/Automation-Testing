package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
	}
	
	
	
	By email = By.id("fldEmailAddressSml");
	By password = By.id("fldPasswordSml");
	By errormsg = By.xpath("//div[@class='text-small message message--error']");

	By submitBtn = By.id("login");
	
	
	//Method to enter username
	public void enterUsername(String user) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(user);
	}

	//Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	
	//Method to click on Login button
	public void clickLogin() {
		driver.findElement(submitBtn).click();
	}
	public String geterrormsg() {
		String msg = driver.findElement(errormsg).getText();
		return msg;
	}
}
