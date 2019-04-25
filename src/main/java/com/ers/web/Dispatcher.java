package com.ers.web;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.LoginData;
import com.ers.services.EmployeeService;
import com.ers.services.EmployeeServiceImp;
import com.ers.services.LoginServiceImp;
import com.ers.services.LoginServices;

public class Dispatcher {
	private static final EmployeeService employeeService = new EmployeeServiceImp();
	private final static LoginServices loginService = new LoginServiceImp();

	private static final String url = "/api";

	private Dispatcher() {}

	public static Object process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String uri = request.getRequestURI().replace(url, "");

		switch (uri) {
		case "/login":
		{
			final LoginData user = loginService.attemptAuthentication(request, response);
			if (user != null) {
				request.getSession().setAttribute("username", user.getUsername());
				request.getSession().setAttribute("job_id", user.getJob_id());
				request.getRequestDispatcher("/authenticated.jsp").forward(request, response);			
			} 
//			else {
//				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				return;
//			}
		}
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
