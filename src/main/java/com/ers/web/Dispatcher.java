package com.ers.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.LoginData;
import com.ers.model.Reimbursement;
import com.ers.services.EmployeeService;
import com.ers.services.EmployeeServiceImp;
import com.ers.services.LoginServiceImp;
import com.ers.services.LoginServices;
import com.ers.services.ReimbursementService;
import com.ers.services.ReimbursementServiceImp;

public class Dispatcher {
	private static final EmployeeService employeeService = new EmployeeServiceImp();
	private static final ReimbursementService reimbursementService = new ReimbursementServiceImp();

	private static final String url = "/ERS";

	private Dispatcher() {}

	public static Object process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String uri = request.getRequestURI().replace(url, "");

		
		System.out.println(uri);
		switch (uri) {
		case "/Reimbursement":
			return reimbursementService.requestAllReimbursements(request, response);
		case "/employees":
			return employeeService.getAllEmployees(request, response);
		default:
			return Collections.singletonMap("message", "Not yet implemented: " + uri);
		}
	}
	
	public static Object processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String uri = request.getRequestURI().replace(url, "");

		switch (uri) {
		case "/Reimbursement":
			return reimbursementService.requestAllReimbursements(request, response);
		case "/employees":
			return employeeService.getAllEmployees(request, response);
		default:
			return Collections.singletonMap("message", "Not yet implemented: " + uri);
		}
	}
}
