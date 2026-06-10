package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
public class HomePageTest extends BaseTest {

	@Test
	public void verifySignupButton() {

		HomePage home = new HomePage(driver);

		home.clickSignupLogin();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));

		System.out.println("Signup button clicked successfully");
	}
}