package com.final12.final12auth.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.final12.final12auth.entities.User;

public interface UserService {

	User findByEmail(String email) throws Exception;
	
	UserDetails loadUserByUsername(String username) throws Exception;
}
