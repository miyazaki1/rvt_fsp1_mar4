package com.project1.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.dao.LoginDao;
import com.project1.dao.LoginDaoImp;
import com.project1.model.LoginData;

public class LoginServiceImp implements LoginServices {
	private final LoginDao dao = new LoginDaoImp();

	@Override
	public LoginData attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		if (username == null || password == null)
			return null;
		
		return dao.attemptAuthentication(username, password);
	}
}
