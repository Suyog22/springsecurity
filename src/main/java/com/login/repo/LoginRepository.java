package com.login.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.bean.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer>{
	Login findByUsername(String username);  
}
