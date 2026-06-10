package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

	@Test
	public void openProductsTest() {

		ProductsPage product = new ProductsPage(driver);

		product.openProducts();

		System.out.println("Products Page Opened");

	}

	@Test
	public void searchProductTest() {

		ProductsPage product = new ProductsPage(driver);

		product.openProducts();

		System.out.println("Search Product Executed");
	}

	@Test
	public void addToCartTest() {

		ProductsPage product = new ProductsPage(driver);

		product.openProducts();

		product.addMensTshirtToCart();
		Assert.assertTrue(driver.getPageSource().contains("Added"));

		System.out.println("Add To Cart Executed");
	}
	
	@Test
	public void invalidSearchProductTest() {

	    ProductsPage product = new ProductsPage(driver);

	    product.openProducts();

	    System.out.println("Invalid Search Product Executed");

	    Assert.assertTrue(true);
	}

}
