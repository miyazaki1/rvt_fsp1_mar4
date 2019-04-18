package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Employee;
import com.project1.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public static final String insert = "INSERT INTO Employees (employee_id, first_name, last_name, email, job_id) Values (?,?,?,?,?)";
	public static final String update = "UPDATE EMPLOYEES";

	public List<Employee> getAllEmployees() {
		System.out.println("Conducting get all Employees");

		List<Employee> employees = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

			while (rs.next()) {
				employees.add(new Employee(rs.getInt("employee_id"), 
						rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getInt("job_id")));				
				//System.out.println(rs.getString("first_name"));
			}
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
		for (int i = 0; i < getAllEmployees().size(); i++) {
			if (getAllEmployees().get(i) == toBeUpdated) {
				System.out.println("Found employee to be updated employedId: " + toBeUpdated.getEmployee_id());

				try (Connection conn = ConnectionFactory.getConnection()) {
					String params = "SET first_name = \'" + toBeUpdated.getFirst_name() + "\' , last_name = \'"
							+ toBeUpdated.getLast_name() + "\' , email = \'" + toBeUpdated.getEmail() + "\' ";

					String where = "WHERE employee_id = \'" + String.valueOf(toBeUpdated.getEmployee_id()) + "\'";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(params + where);
					System.out.println(rs);

					return toBeUpdated;
				} catch (SQLException e) {
					e.printStackTrace();
				}

				System.out.println("Failed to update employee: " + toBeUpdated.getEmployee_id() + ", "
						+ toBeUpdated.getFirst_name() + " " + toBeUpdated.getLast_name());
				return toBeUpdated;
			}
		}
		return toBeUpdated;
	}

	public long removeEmployee(Employee... toBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

}
