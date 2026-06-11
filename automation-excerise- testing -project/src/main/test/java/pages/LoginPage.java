package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    By email = By.name("email");
    By password = By.name("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");

    // Fixed Locator
    By errorMessage =
            By.xpath("//p[contains(text(),'incorrect')]");

    public void enterEmail(String userEmail) {

        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPassword(String userPassword) {

        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();
    }
}