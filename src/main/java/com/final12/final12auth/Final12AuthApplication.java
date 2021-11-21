package com.final12.final12auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class Final12AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(Final12AuthApplication.class, args);
	}

}
