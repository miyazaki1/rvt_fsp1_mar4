package com.ers.dao;

import com.ers.model.LoginData;

public interface LoginDao {	
	LoginData attemptAuthentication(String username, String password);
}
