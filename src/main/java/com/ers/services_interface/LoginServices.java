package com.ers.services_interface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.LoginData;

public interface LoginServices {
	
	LoginData attemptAuthentication(HttpServletRequest req, HttpServletResponse resp);
}
