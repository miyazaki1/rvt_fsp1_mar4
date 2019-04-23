package com.ers.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private final static String localUsername = "homeuser";
	private final static String localPassword = "password2";
	private final static String localUrl = "jdbc:oracle:thin:@localhost:1521:xe";

	private final static String awsUsername = "miyazaki1";
	private final static String awsPassword = "KinomotoSakura10";
	private final static String awsUrl = "dbc:oracle:thin:miyakei-rdbs.cuhnfxjtmc7x.us-east-1.rds.amazonaws.com:1521";
	
	private ConnectionFactory() {
	}

	public static Connection getConnection() {
		return getOracleConnection();
	}
	
	public static Connection getOracleConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			return DriverManager.getConnection(localUrl, localUsername, localPassword);
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get database connection");
		}

		catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Database Driver");
		}
	}
	
	public Connection getAWSConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			return DriverManager.getConnection(awsUrl, awsUsername, awsPassword);
		} catch (SQLException e) {
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
			throw new RuntimeException("Failed to get database connection");
		}

		catch (ClassNotFoundException e) {
			throw new RuntimeException("Failed to locate Database Driver");
		}
	}
}
