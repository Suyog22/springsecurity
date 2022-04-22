package com.login.service;

import java.util.List;

import com.login.bean.Login;

public interface LoginService {

	public List<Login> getAllUsers();
	
	public void addUser(Login login);
}
