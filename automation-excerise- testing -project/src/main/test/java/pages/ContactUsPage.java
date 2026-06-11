package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	By contactUsBtn = By.xpath("//a[contains(text(),'Contact us')]");

	By nameField = By.name("name");

	By emailField = By.name("email");

	By subjectField = By.name("subject");

	By messageField = By.id("message");

	By submitBtn = By.name("submit");

	public void openContactUs() {
		driver.findElement(contactUsBtn).click();
	}

	public void enterName(String name) {
		driver.findElement(nameField).sendKeys(name);
	}

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterSubject(String subject) {
		driver.findElement(subjectField).sendKeys(subject);
	}

	public void enterMessage(String message) {
		driver.findElement(messageField).sendKeys(message);
	}

	public void clickSubmit() {
		driver.findElement(submitBtn).click();
	}
}