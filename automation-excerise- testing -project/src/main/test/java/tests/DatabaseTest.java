package tests;

import org.testng.annotations.Test;

import utils.DBUtil;

public class DatabaseTest {

	@Test
	public void testConnection() {

		DBUtil.getConnection();

	}

	@Test
	public void readEmailTest() {

		String email = DBUtil.getEmail();

		System.out.println("Email = " + email);

	}
	@Test
	public void readCredentialsTest() {

	    System.out.println(DBUtil.getEmail());
	    System.out.println(DBUtil.getPassword());

	}
}