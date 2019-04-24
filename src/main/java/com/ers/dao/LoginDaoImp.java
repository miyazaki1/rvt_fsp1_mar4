package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.connection.ConnectionFactory;
import com.ers.model.LoginData;

public class LoginDaoImp implements LoginDao {

	@Override
	public LoginData attemptAuthentication(String username, String password) {
		System.out.println("#### Inside attemptAuthentication in LoginDaoImp ####\n");

		try (Connection conn = ConnectionFactory.getConnection()) {

			PreparedStatement stmt = conn.prepareCall("SELECT * FROM employees WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("#### Logged in as: #### \n" + "username: " + rs.getString("username")
						+ ", first name: " + rs.getString("first_name"));
				return new LoginData(rs.getInt("employee_id"), rs.getInt("job_id"), rs.getString("username"));
			}
		} catch (SQLException e) {

		}
		return null;
	}
}
