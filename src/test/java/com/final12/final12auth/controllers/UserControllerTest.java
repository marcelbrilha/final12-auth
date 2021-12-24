package com.final12.final12auth.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.final12.final12auth.services.UserService;
import com.final12.final12auth.web.rest.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@MockBean
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void findAllUsers() throws Exception {
		mockMvc.perform(get("/api/auth/v1/users?email=marcelbrilha@yahoo.com.br")).andExpect(status().isUnauthorized());
	}
	
}
