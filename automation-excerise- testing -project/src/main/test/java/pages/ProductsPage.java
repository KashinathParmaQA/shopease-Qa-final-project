package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By productsMenu = By.xpath("//a[@href='/products']");

    By searchBox = By.id("search_product");

    By searchButton = By.id("submit_search");

    By viewCartBtn = By.xpath("//u[text()='View Cart']");

    By menTshirtAddCart =
            By.xpath("//a[@data-product-id='2']");

    By continueShoppingBtn =
            By.xpath("//button[text()='Continue Shopping']");

    public void openProducts() {

        driver.findElement(productsMenu).click();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchProduct(String productName) {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox)
                .sendKeys(productName);

        driver.findElement(searchButton).click();
    }

    public void addMensTshirtToCart() {

        WebElement addCart =
                driver.findElement(menTshirtAddCart);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                addCart);
    }

    public void clickContinueShopping() {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.findElement(
                continueShoppingBtn).click();
    }

    public void clickViewCart() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.location='https://automationexercise.com/view_cart';");
    }
}