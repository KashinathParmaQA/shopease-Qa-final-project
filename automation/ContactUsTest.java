package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

	@Test
	public void contactUsTest() {

		ContactUsPage contact = new ContactUsPage(driver);

		contact.openContactUs();

		contact.enterName("Kashinath");

		contact.enterEmail("kashinath@gmail.com");

		contact.enterSubject("Automation Testing");

		contact.enterMessage("Testing Contact Us Form");

		contact.clickSubmit();

		driver.switchTo().alert().accept();

		System.out.println("Contact Us Form Submitted");
	}
}