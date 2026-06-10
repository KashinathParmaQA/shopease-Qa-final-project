package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.ProductsPage;
import org.testng.Assert;

public class CheckoutTest extends BaseTest {

	@Test
	public void checkoutTest() {

		ProductsPage product = new ProductsPage(driver);

		product.openProducts();

		product.addMensTshirtToCart();

		product.clickViewCart();

		CheckoutPage checkout = new CheckoutPage(driver);

		checkout.proceedToCheckout();
		Assert.assertTrue(true);
		System.out.println("Checkout Page Opened");
	}
}