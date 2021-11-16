package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	
WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public homePage(WebDriver driver) {
		this.driver=driver;
	}
	By loginBtn = By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[6]/td[2]/input");
	
	By registerBtn = By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[7]/td/a");
	
	By BacktoLogin = By.xpath("//*[@id=\"register_form\"]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a");
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	public void clickRegister() {
		driver.findElement(registerBtn).click();
	}
	public void BacktoLoginBtn() {
		driver.findElement(BacktoLogin).click();
	}
}
