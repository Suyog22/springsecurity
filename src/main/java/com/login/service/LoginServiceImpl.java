package com.login.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.login.bean.Login;
import com.login.exception.InvalidUserException;
import com.login.repo.LoginRepository;
import com.login.util.JwtUtils;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	AuthenticationManager authManager;
	
	Logger log = LoggerFactory.getLogger(LoginServiceImpl.class); 
	
	@Override
	public List<Login> getAllUsers() {
		return (List<Login>) loginRepository.findAll();
	}
	
	public void addUser(Login login) {
		loginRepository.save(login);
		log.info("User inserted successfully");
	}
	
	@Override
	public String signIn(Login login) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		return jwtUtils.generateToken(login.getUsername());		
	}

	@Override
	public boolean isTokenValid(String jwtToken) {
		String username = jwtUtils.extractUsername(jwtToken);
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
		return jwtUtils.validateToken(jwtToken, userDetails);
	}

}
