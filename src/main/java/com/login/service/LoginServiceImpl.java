package com.login.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.bean.Login;
import com.login.repo.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	Logger log = LoggerFactory.getLogger(LoginServiceImpl.class); 
	
	@Override
	public List<Login> getAllUsers() {
		return (List<Login>) loginRepository.findAll();
	}
	
	public void addUser(Login login) {
		loginRepository.save(login);
		log.info("User inserted successfully");
	}

}
