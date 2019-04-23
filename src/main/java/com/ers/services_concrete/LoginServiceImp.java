package com.ers.services_concrete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao_concrete.LoginDaoImp;
import com.ers.dao_interface.LoginDao;
import com.ers.model.LoginData;
import com.ers.services_interface.LoginServices;

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
