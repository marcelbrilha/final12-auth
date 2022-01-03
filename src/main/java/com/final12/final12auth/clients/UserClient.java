package com.final12.final12auth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.final12.final12auth.entities.User;

@Component
@FeignClient(name = "final12-user", url = "${app.final12-user.url}")
public interface UserClient {

	@GetMapping(value = "/api/v1/users")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
