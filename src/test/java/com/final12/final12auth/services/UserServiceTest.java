package com.final12.final12auth.services;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.final12.final12auth.clients.UserClient;
import com.final12.final12auth.entities.User;
import com.final12.final12auth.exceptions.ObjectNotFoundException;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@MockBean
	UserClient userClient;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@TestConfiguration
	static class UserServiceTestConfiguration {
		
		@Bean
		public UserService osService() {
			return new UserService();
		}
		
	}
	
	@Test
	public void loadUserByEmail() throws Exception {
		String email = "marcelbrilha@yahoo.com.br"; 
		User user = new User();
		user.setEmail(email);
		
		Mockito.when(userClient.findByEmail(email)).thenReturn(ResponseEntity.ok(user));
		
		UserDetails response = userService.loadUserByUsername(email);
		Assert.assertEquals(response.getUsername(), email);
	}
	
	@Test
	public void loadUserByEmailThrowUsernameNotFoundException() throws Exception {
		String email = "marcelbrilha@yahoo.com.br"; 
		Mockito.when(userClient.findByEmail(email)).thenReturn(ResponseEntity.ok(null));
		
		exception.expect(UsernameNotFoundException.class);
		exception.expectMessage("E-mail not found");
		
		userService.loadUserByUsername(email);
	}
	
	@Test
	public void findByEmail() throws Exception {
		String email = "marcelbrilha@yahoo.com.br"; 
		User user = new User();
		user.setEmail(email);
		
		Mockito.when(userClient.findByEmail(email)).thenReturn(ResponseEntity.ok(user));
		
		UserDetails response = userService.findByEmail(email);
		Assert.assertEquals(response.getUsername(), email);
	}
	
	@Test
	public void findByEmailThrowUsernameNotFoundException() throws Exception {
		String email = "marcelbrilha@yahoo.com.br";
		Mockito.when(userClient.findByEmail(email)).thenReturn(ResponseEntity.ok(null));
		
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("E-mail not found");
		
		userService.findByEmail(email);
	}
}
