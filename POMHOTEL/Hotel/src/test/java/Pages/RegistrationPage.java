package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {


	WebDriver driver;
	
	 public RegistrationPage(WebDriver driver) {
        this.driver = driver;
	}
	 By username = By.id("username");
	 By password = By.id("password");
	 By confirmPass = By.id("re_password");
	 By fullName = By.id("full_name");
	 By email = By.id("email_add");
	 By captchaText =By.id("captcha-form");
	 By TermsAndConditions =By.id("tnc_box");
	 By  submitBtn = By.id("Submit");
	 By  login = By.xpath("//*[@id=\"register_form\"]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a");
	 
	 public void username(String Lusername) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(Lusername);
	 }
	 
	 public void password(String wpassword) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(wpassword);
	 }
	 
	 public void confiPass(String wconfiPass) {
		driver.findElement(confirmPass).clear();
		driver.findElement(confirmPass).sendKeys(wconfiPass);
	 }
	 
	 public void fullName(String wfullName) {
		driver.findElement(fullName ).clear();
		driver.findElement(fullName ).sendKeys(wfullName);
	 }
	 
	 public void email(String wemail) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(wemail);
	 }
	 
	 public void captchaText(String wemail) {
		driver.findElement(captchaText).clear();
		driver.findElement(captchaText).sendKeys(wemail);
	 }
	 
	 public void clickRegister() {
		 driver.findElement(submitBtn).click();
	 }
	 public void clickLogin() {
		 driver.findElement(login).click();
	 }
	 
	 public void clickTerms() {
		 driver.findElement(TermsAndConditions).click();
	 }
	 
	 
}