package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBUtil {

	public static Connection getConnection() {

		Connection con = null;

		try {

			String url = "jdbc:postgresql://localhost:5432/automation_testing_db";
			String username = "postgres";
			String password = "1234";

			con = DriverManager.getConnection(url, username, password);

			System.out.println("Database Connected Successfully");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return con;
	}

	public static String getEmail() {

		String email = "";

		try {

			Connection con = getConnection();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT email FROM users LIMIT 1");

			if (rs.next()) {

				email = rs.getString("email");

			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return email;
	}

	public static String getPassword() {

		String password = "";

		try {

			Connection con = getConnection();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT password FROM users LIMIT 1");

			if (rs.next()) {

				password = rs.getString("password");

			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return password;
	}
}