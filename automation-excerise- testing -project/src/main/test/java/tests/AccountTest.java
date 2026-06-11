package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class AccountTest extends BaseTest {

    @Test
    public void verifyAccountPageTest() {

        HomePage home = new HomePage(driver);

        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);

        login.enterEmail("kashinathparma444@gmail.com");

        login.enterPassword("kashinath123");

        login.clickLogin();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Logged in as"));

        System.out.println("Account Page Verified");
    }
}