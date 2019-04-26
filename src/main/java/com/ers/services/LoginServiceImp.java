package com.ers.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.dao.LoginDao;
import com.ers.dao.LoginDaoImp;
import com.ers.model.LoginData;

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
	
	public LoginData LogOut(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(false);
		if(session != null)
		session.invalidate();
		try {
			req.getRequestDispatcher("/index.jsp").forward(req,resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
