package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {
	
	WebDriver driver;
	
	public Search(WebDriver driver) {
       this.driver = driver;
	}
	By location = By.id("location"); 
    By hotels = By.id("hotels"); 
    By roomType = By.id("room_type"); 
    By numberOfRooms = By.id("room_nos"); 
    By checkInDate = By.id("datepick_in"); 
    By checkOutDate = By.id("datepick_out"); 
    By udult = By.id("adult_room"); 
    By children = By.id("child_room"); 
    By search = By.id("Submit");

    
    public void location(String Loca) {
		driver.findElement(location).sendKeys(Loca);
	 }
    public void hotels(String Lusername) {
		driver.findElement(hotels).sendKeys(Lusername);
	 }
    public void roomType(String Lusername) {
		driver.findElement(roomType).sendKeys(Lusername);
	 }
    public void numberOfRooms(String Lusername) {
		driver.findElement(numberOfRooms).sendKeys(Lusername);
	 }
    public void checkInDate(String Lusername) {
		driver.findElement(checkInDate).clear();
		driver.findElement(checkInDate).sendKeys(Lusername);
	 }
    public void checkOutDate(String Lusername) {
		driver.findElement(checkOutDate).clear();
		driver.findElement(checkOutDate).sendKeys(Lusername);
	 }
    public void udult(String Lusername) {
		driver.findElement(udult).sendKeys(Lusername);
	 }
    public void children(String Lusername) {
		driver.findElement(children).sendKeys(Lusername);
	 }
    public void search () {
		driver.findElement(search).click();
	 }
}
