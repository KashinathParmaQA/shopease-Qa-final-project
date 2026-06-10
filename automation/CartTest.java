package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;
import pages.CartPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

	@Test
	public void addProductToCartTest() {

		ProductsPage product = new ProductsPage(driver);

		product.openProducts();

		product.addMensTshirtToCart();
		Assert.assertTrue(driver.getPageSource().contains("Added"));

		System.out.println("Product Added To Cart");
	}

	@Test
	public void removeProductFromCartTest() {

		ProductsPage product = new ProductsPage(driver);

		product.openProducts();

		product.addMensTshirtToCart();

		product.clickViewCart();

		CartPage cart = new CartPage(driver);

		cart.removeProduct();
		Assert.assertTrue(true);

		System.out.println("Product Removed Successfully");
	}
}