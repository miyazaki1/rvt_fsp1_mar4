package com.project1.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.model.LoginData;

public interface LoginServices {
	
	LoginData attemptAuthentication(HttpServletRequest req, HttpServletResponse resp);
}
