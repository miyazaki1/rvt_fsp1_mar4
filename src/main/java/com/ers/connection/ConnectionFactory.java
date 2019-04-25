package com.ers.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Properties props = getJdbcProperties();	
	private ConnectionFactory() {}

	public static Connection getConnection() {
		return getOracleConnection();
	}
	
	public static Connection getOracleConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"),
					props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get database connection");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Database Driver");
		}
	}
	public static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load application.properties");
		}
		return props;
	}
}
