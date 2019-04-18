package com.project1.web;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.services.EmployeeService;
import com.project1.services.EmployeeServiceImp;

public class Dispatcher {
	private static final EmployeeService employeeService = new EmployeeServiceImp();
	private static final String url = "/ERS/api";

	private Dispatcher() {}

	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request.getRequestURI().replace(url, "");

		switch (uri) {
		case "/employees":
			return employeeService.getAllEmployees(request, response);
		default:
			return Collections.singletonMap("message", "Not yet implemented");
		}
	}
	
	public static Object processPost(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request.getRequestURI().replace(url, "");

		switch (uri) {
		case "/employees":
			return employeeService.getAllEmployees(request, response);
		default:
			return Collections.singletonMap("message", "Not yet implemented");
		}
	}
}
