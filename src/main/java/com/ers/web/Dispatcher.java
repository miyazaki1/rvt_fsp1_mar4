package com.ers.web;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.LoginDao;
import com.ers.dao.LoginDaoImp;
import com.ers.services.EmployeeService;
import com.ers.services.EmployeeServiceImp;
import com.ers.services.ReimbursementService;
import com.ers.services.ReimbursementServiceImp;

public class Dispatcher {
	private static final EmployeeService employeeService = new EmployeeServiceImp();
	private static final ReimbursementService reimbursementService = new ReimbursementServiceImp();
	private static final LoginDao loginServices = new LoginDaoImp();
	private static final String url = "/ERS";

	private Dispatcher() {}

	public static Object process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String uri = request.getRequestURI().replace(url, "");

		System.out.println(uri);
		switch (uri) {
		case "/Employees":
			return employeeService.getAllEmployees(request, response);
		case "/EUpdate":
			return employeeService.updateEmployee(request, response);
		case "/Reimbursement":
			return reimbursementService.requestAllReimbursements(request, response);
		case "/CreateReimbursement":
			return reimbursementService.createReimbursement(request, response);
		case "/ApproveRe":
			return reimbursementService.approveReimbursement(request, response);
		case "/DenyRe":
			return reimbursementService.denyReimbursement(request, response);
		case "/Logout":{
			request.getSession().invalidate();
			return loginServices.LogOut();
		}
		default:
			return Collections.singletonMap("message", "Not yet implemented: " + uri);
		}
	}
	
	public static Object processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String uri = request.getRequestURI().replace(url, "");
		System.out.println(uri);

		switch (uri) {		
		case "/Employees":
			return employeeService.getAllEmployees(request, response);
		case "/EUpdate":
			return employeeService.updateEmployee(request, response);
		case "/Reimbursement":
			return reimbursementService.requestAllReimbursements(request, response);
		case "/CreateReimbursement":
			return reimbursementService.createReimbursement(request, response);
		case "/ApproveRe":
			return reimbursementService.approveReimbursement(request, response);
		case "/DenyRe":
			return reimbursementService.denyReimbursement(request, response);
		case "/Logout":{
			request.getSession().invalidate();
			return loginServices.LogOut();
		}
		default:
			return Collections.singletonMap("message", "Not yet implemented: " + uri);
		}
	}
}
