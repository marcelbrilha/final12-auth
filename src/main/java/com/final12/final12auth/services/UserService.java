package com.final12.final12auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.final12.final12auth.clients.UserClient;
import com.final12.final12auth.entities.User;
import com.final12.final12auth.exceptions.ObjectNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userClient.findByEmail(username).getBody();

		if (user == null) {
			log.error("Usuário não encontrado: " + username);
			throw new UsernameNotFoundException("E-mail not found");
		}

		log.info("Usuário encontrado: " + username);
		return user;
	}
	
	public User findByEmail(String email) throws Exception {
		User user = this.userClient.findByEmail(email).getBody();
		
		if (user == null) {
			log.error("E-mail não encontrado: " + email);
			throw new ObjectNotFoundException("E-mail not found");
		}

		log.info("E-mail encontrado: " + email);
		return user;
	}
}
