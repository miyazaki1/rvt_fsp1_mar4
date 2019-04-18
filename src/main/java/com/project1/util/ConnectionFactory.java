package com.project1.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static final Properties props = getJdbcProperties();

	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"),
					props.getProperty("jdbc.password"));
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get database connection");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate H2 Database Driver");
		}
	}

	private static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load [application.properties]");
		}
		return props;
	}
}
