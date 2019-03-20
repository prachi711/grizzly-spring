package com.cts.grizzlywebstore.dao;

import com.cts.grizzlywebstore.bean.Login;


public interface LoginDao {
	
	public String validateUser(Login login);

}
