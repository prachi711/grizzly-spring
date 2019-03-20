package com.cts.grizzlywebstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlywebstore.bean.Login;
import com.cts.grizzlywebstore.dao.LoginDao;


@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao loginDao;

	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS)// support ongoing transaction, apply on every service
	public String validateUser(Login login) {
		// TODO Auto-generated method stub
		return loginDao.validateUser(login);

}
}
