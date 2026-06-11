package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) { // constructor

		this.driver = driver;

	}

	// locators
	By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
	By signupLogin = By.xpath("//a[contains(text(),'Signup / Login')]"); // locator

	// methods
	public void clickSignupLogin() { // methods

		driver.findElement(signupLogin).click();
	}

	public void clickLogout() {
	        driver.findElement(logoutBtn).click();
	
	        
	        
  }
}



