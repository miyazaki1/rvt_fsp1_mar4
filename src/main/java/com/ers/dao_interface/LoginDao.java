package com.ers.dao_interface;

import com.ers.model.LoginData;

public interface LoginDao {
	
	LoginData attemptAuthentication(String username, String password);
}
