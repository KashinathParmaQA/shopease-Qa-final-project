package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.DBUtil;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);

        String email = DBUtil.getEmail();
        String password = DBUtil.getPassword();

        login.enterEmail(email);
        login.enterPassword(password);
        login.clickLogin();

        AccountPage account = new AccountPage(driver);

        Assert.assertTrue(account.isUserLoggedIn(),
                "User login verification failed");

        System.out.println("Login test executed");
    }

    @Test
    public void invalidLoginTest() {

        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);

        login.enterEmail("wrong@gmail.com");
        login.enterPassword("wrong123");
        login.clickLogin();

        Assert.assertEquals(
                login.getErrorMessage(),
                "Your email or password is incorrect!"
        );

        System.out.println("Invalid Login Executed");
    }

    @Test
    public void logoutTest() {

        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);

        String email = DBUtil.getEmail();
        String password = DBUtil.getPassword();

        login.enterEmail(email);
        login.enterPassword(password);
        login.clickLogin();

        AccountPage account = new AccountPage(driver);

        Assert.assertTrue(account.isUserLoggedIn());

        home.clickLogout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"),
                "Logout failed"
        );

        System.out.println("Logout Executed");
    }
}