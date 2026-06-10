package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;
import pages.HomePage;
import pages.SignupPage;

public class SignupTest extends BaseTest {

	@Test
	public void signupTest() {

		HomePage home = new HomePage(driver);

		home.clickSignupLogin();

		SignupPage signup = new SignupPage(driver);

		signup.enterName("Kashinath");

		signup.enterEmail("kashinath" + System.currentTimeMillis() + "@gmail.com");

		signup.clickSignup();
		Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
		System.out.println("Signup Executed Successfully");
	}
	@Test
	public void signupPageOpenTest() {

	    HomePage home = new HomePage(driver);

	    home.clickSignupLogin();

	    Assert.assertTrue(
	            driver.getCurrentUrl().contains("login"));

	    System.out.println("Signup Page Open Test Executed");
	}
}