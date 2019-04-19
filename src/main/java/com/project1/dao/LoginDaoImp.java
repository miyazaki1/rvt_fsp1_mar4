package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.LoginData;
import com.project1.util.ConnectionFactory;

public class LoginDaoImp implements LoginDao{

	@Override
	public LoginData attemptAuthentication(String username, String password) {
		System.out.println("#attemptAuthentication");
		try (Connection conn = ConnectionFactory.getConnection()) {
			/*
			PreparedStatement stmt = conn.prepareCall("SELECT * FROM employees WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("username: "  + rs.getString("username") + " first name: " + rs.getString("first_name"));
				return new LoginData(rs.getInt("employee_id"), rs.getInt("job_id"), rs.getString("username"));
			
			}*/
		} catch (SQLException e) {
			
		} 
		return null;
	}

}
