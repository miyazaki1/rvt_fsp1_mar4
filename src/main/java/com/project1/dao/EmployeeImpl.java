package com.project1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project1.model.Employee;
import com.project1.util.ConnectionFactory;

public class EmployeeImpl implements EmployeeDao {

	public static final String insert = "INSERT INTO Employees (id,employee_id, amount, status_id, request_date)";
	
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

			while (rs.next()) {
				employees.add(new Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("email"), rs.getInt("job_id")));
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
		for (int i = 0; i < getAllEmployees().size(); i++) {
			if (getAllEmployees().get(i) == employee) {
				System.out.println("Cannot #addEmployee, employee already exists");
				return null;
			}
		}			
		try (Connection conn = ConnectionFactory.getConnection()) {
			String params =  "(" + String.valueOf(employee.getEmployee_id()) + "," + 
					employee.getFirst_name() + "," + employee.getLast_name() + "," + employee.getEmail() + ","
					+ String.valueOf(employee.getJob_id() + ")");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(insert + " Values " + params);
			
			System.out.println(rs);
			
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee updateEmployee(Employee toBeUpdated) {
		
		return toBeUpdated;
	}

	public long removeEmployee(Employee... toBeDeleted) {
		// TODO Auto-generated method stub
		return 0;
	}

}
