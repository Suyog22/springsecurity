package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.bean.Login;
import com.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/")
	public ResponseEntity<List<Login>> getAllUsers() {
		return new ResponseEntity<List<Login>>(loginService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addUser(@RequestBody Login login) {
		loginService.addUser(login);
		return new ResponseEntity<String>("User added successfully", HttpStatus.CREATED);
	}

}
