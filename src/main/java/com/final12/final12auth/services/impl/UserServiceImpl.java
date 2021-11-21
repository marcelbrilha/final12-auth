package com.final12.final12auth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.final12.final12auth.clients.UserClient;
import com.final12.final12auth.entities.User;
import com.final12.final12auth.exceptions.ObjectNotFoundException;
import com.final12.final12auth.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserClient userClient;

	@Override
	public User findByEmail(String email) throws Exception {
		User user = this.userClient.findByEmail(email).getBody();
		
		if (user == null) {
			log.error("E-mail não encontrado: " + email);
			throw new ObjectNotFoundException("E-mail not found");
		}

		log.info("E-mail encontrado: " + email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws Exception {
		User user = this.userClient.findByEmail(username).getBody();

		if (user == null) {
			log.error("Usuário não encontrado: " + username);
			throw new ObjectNotFoundException("E-mail not found");
		}

		log.info("Usuário encontrado: " + username);
		return user;
	}
}
