package com.poc.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionUtility {
	private static final String URL = "jdbc:mysql://localhost:3306/youtube";
	private static final String username = "root";
	private static final String password = "ismail@123";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}
}
