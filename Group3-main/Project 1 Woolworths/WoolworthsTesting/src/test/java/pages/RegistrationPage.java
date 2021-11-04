package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {


	WebDriver driver;
	
	 public RegistrationPage(WebDriver driver) {
        this.driver = driver;
	}
	

	
	By title = By.id("fldTitle");
	By firstName = By.id("fldFirstName");
	By lastName = By.id("fldLastName");
	By email = By.id("fldEmailAddress");
	By confirmEmail = By.id("fldConfirmEmailAddress");
	By password = By.id("fldPassword");
	By confirmPassword = By.id("fldConfirmPassword");
	By contact = By.id("fldContactNumber");
	By errormsg = By.xpath("//span[@class='form-field__msg form-field__msg--error']");

	By submitBtn = By.id("fldSubmit");
	
	//Locator for login button
	By LoginBtn = By.xpath("/html/body/div[1]/div/div[1]/div/main/div/article/div[2]/aside/section[1]/a");
By homeBtmBy = By.xpath("/html/body/div[1]/div/div[1]/div/main/div/article/div[1]/div[2]/ul/li[2]/a");
	
	public void title(String wtitle) {

		driver.findElement(title).sendKeys(wtitle);
	}

	//Method to enter firstName
	public void firstName(String wfirstName) {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(wfirstName);
	}
	
	//Method to enter lastName
		public void lastName(String wlastName) {
			driver.findElement(lastName).clear();
			driver.findElement(lastName).sendKeys(wlastName);
		}

		//Method to enter email
		public void email(String wemail) {
			driver.findElement(email).clear();
			driver.findElement(email).sendKeys(wemail);
		}
		//Method to enter confirmEmail
		public void confirmEmail(String wconfirmEmail) {
			driver.findElement(confirmEmail).clear();
			driver.findElement(confirmEmail).sendKeys(wconfirmEmail);
		}

		//Method to enter password
		public void password(String wpassword) {
			driver.findElement(password).clear();
			driver.findElement(password).sendKeys(wpassword);
		}
		
		//Method to enter confirmPassword
		public void confirmPassword(String wconfirmPassword) {
			driver.findElement(confirmPassword).clear();
			driver.findElement(confirmPassword).sendKeys(wconfirmPassword);
		}

		//Method to enter contact
		public void contact(String wcontact) {
			driver.findElement(contact).clear();
			driver.findElement(contact).sendKeys(wcontact);
		}
	
	//Method to click on Register button
	public void clickRegister() {
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", submitBtn);
		driver.findElement(submitBtn).click();
	}
	
	//Method to click on Register button
	public void clickHome() {
		

		driver.findElement(homeBtmBy).click();
	}
	public void clickLogin() {
		driver.findElement(LoginBtn).click();
	}
	
	public void geterrormsg() {
		driver.findElement(errormsg).getText();
		
	}
}
