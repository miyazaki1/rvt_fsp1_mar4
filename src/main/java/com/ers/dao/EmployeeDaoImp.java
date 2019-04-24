package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ers.connection.ConnectionFactory;
import com.ers.model.Employee;

public class EmployeeDaoImp implements EmployeeDao {

	public static final String insert = "INSERT INTO Employees (employee_id, first_name, last_name, email, job_id, username, password) Values (?,?,?,?,?,?,?)";
	public static final String update = "Update Employees SET first_name = ?, last_name = ?, email = ?, job_id = ? where employee_id = ?";
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

			while (rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"), 
						rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getInt("job_id"), 
						rs.getString("username"), rs.getString("password")));				
				//System.out.println(rs.getString("first_name"));
			}
			//System.out.println("Conducting get all Employees");

			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployeeById(int id) {
		for (int i = 0; i < getAllEmployees().size(); i++) {
			if (getAllEmployees().get(i).getEmployee_id() == id) {
				return getAllEmployees().get(i);
			}
		}
		return null;
	}

	public Employee addEmployee(Employee employee) {

		// Checks if employee exists - if exists, exits with null
		for (int i = 0; i < getAllEmployees().size(); i++) {
			if (getAllEmployees().get(i) == employee) {
				System.out.println("Cannot #addEmployee, employee already exists");
				return null;
			}
		}

		// If employee doesn't exist add employee
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(insert);
			stmt.setInt(1, employee.getEmployee_id());
			stmt.setString(2, employee.getFirst_name());
			stmt.setString(3, employee.getLast_name());
			stmt.setString(4, employee.getEmail());
			stmt.setInt(5, employee.getJob_id());
			stmt.setString(6, employee.getUsername());
			stmt.setString(7, employee.getPassword());


			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1) {
				System.out.println("#addEmployee returned successfully");
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Returns Null if nothing else
		System.out.println("Cannot #addEmployee, returned null");
		return null;
	}

	public Employee updateEmployee(Employee toBeUpdated) {
		System.out.println("Inside #updateEmployee");
		for (int i = 0; i < getAllEmployees().size(); i++) {
			if (getAllEmployees().get(i).getEmployee_id() == toBeUpdated.getEmployee_id()) {
				System.out.println("Found employee to be updated employedId: " + toBeUpdated.getEmployee_id());

				try (Connection conn = ConnectionFactory.getConnection()) {
					PreparedStatement stmt = conn.prepareStatement(update);					
					stmt.setString(1, toBeUpdated.getFirst_name());
					stmt.setString(2, toBeUpdated.getLast_name());
					stmt.setString(3, toBeUpdated.getEmail());
					stmt.setInt(4, toBeUpdated.getJob_id());
					stmt.setInt(5, toBeUpdated.getEmployee_id());
					stmt.setString(6, toBeUpdated.getUsername());
					stmt.setString(7, toBeUpdated.getPassword());
					
					int rowsAffected = stmt.executeUpdate();
					if(rowsAffected ==1) {
						System.out.println("Update Successful");
						return toBeUpdated;
					}	
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("Failed to update employee: " + toBeUpdated.getEmployee_id() + ", "
						+ toBeUpdated.getFirst_name() + " " + toBeUpdated.getLast_name());
				return toBeUpdated;
			}
		}		
		System.out.println("Failed to update employee: " + toBeUpdated.getEmployee_id() + ", "
				+ toBeUpdated.getFirst_name() + " " + toBeUpdated.getLast_name());
		return toBeUpdated;
	}

	public long removeEmployee(Employee... toBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

}
