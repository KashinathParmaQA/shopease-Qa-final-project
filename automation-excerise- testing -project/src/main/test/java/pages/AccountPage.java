package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

	public boolean isUserLoggedIn() {

		try {

			Thread.sleep(3000);

			return driver.findElement(loggedInText).isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}
}


