package com.final12.final12auth.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.final12.final12auth.entities.User;
import com.final12.final12auth.services.UserService;

@RestController
@RequestMapping(value = "/api/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/v1/users")
	public ResponseEntity<User> findByEmail(@RequestParam String email) throws Exception {
		return ResponseEntity.ok(this.userService.findByEmail(email));
	}
}
