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

	public List<LoginData> getAllLoginData() {
		List<LoginData> reimbursements = new ArrayList<>();	
		
		try(Connection conn = ConnectionFactory.getConnection()){
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee_Login");
			
			while(rs.next()) {
				reimbursements.add(new LoginData(rs.getInt("employee_id"),
						rs.getInt("job_id"),
						rs.getString("username")));
			}		
			return reimbursements;
		} catch (SQLException e){
			e.printStackTrace();
		}	
		return null;
	}

	public LoginData getLogindDataByEmployeeId(int employeeId) {
		for(LoginData ld : getAllLoginData()) {
			if( ld.getEmployee_id() == employeeId) {
				return ld;
			}
		}
		return null;
	}

	@Override
	public LoginData attemptAuthentication(String username, String password) {
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareCall("SELECT * FROM employees WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new LoginData(rs.getInt("employee_id"), rs.getInt("job_id"), rs.getString("username"));
			}
		} catch (SQLException e) {
			
		} 
		return null;
	}

}
