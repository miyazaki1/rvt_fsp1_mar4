package com.ers.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.LoginData;
import com.ers.services.LoginServiceImp;
import com.ers.services.LoginServices;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final LoginServices service = new LoginServiceImp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final LoginData user = service.attemptAuthentication(req, resp);
		if (user != null) {
			req.getSession().setAttribute("username", user.getUsername());
			req.getSession().setAttribute("job_id", user.getJob_id());
			req.getSession().setAttribute("employee_id", user.getEmployee_id());
			req.getSession().setAttribute("firstname", user.getFirstname());
			req.getSession().setAttribute("lastname", user.getLastname());
			req.getSession().setAttribute("email",  user.getEmail());

			req.getRequestDispatcher("/authenticated.jsp").forward(req, resp);			
		} else {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
	}
}
