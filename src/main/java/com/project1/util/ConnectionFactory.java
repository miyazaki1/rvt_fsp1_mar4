package com.project1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String username = "homeuser";
	private final static String password = "password2";
	private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//System.out.println("getConnection@Factory");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get database connection");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Oracle Database Driver");
		}
	}
}
