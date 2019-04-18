package com.project1.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.model.Employee;

public interface EmployeeService {
		List<Employee> getAllEmployees(HttpServletRequest request, HttpServletResponse response);
		Employee getEmployeeById(HttpServletRequest request, HttpServletResponse response);
		Employee addEmployee(HttpServletRequest request, HttpServletResponse response);
		Employee updateEmployee(HttpServletRequest request, HttpServletResponse response);
		long removeEmployee(HttpServletRequest request, HttpServletResponse response);
}
