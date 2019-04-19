package com.project1.dao;

import com.project1.model.LoginData;

public interface LoginDao {
	
	LoginData attemptAuthentication(String username, String password);
}
