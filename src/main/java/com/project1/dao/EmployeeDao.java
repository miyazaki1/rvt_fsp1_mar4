package com.project1.dao;

import java.util.List;

import com.project1.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee toBeUpdated);
	long removeEmployee(Employee...toBeDeleted);
}
