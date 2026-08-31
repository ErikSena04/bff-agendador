package com.eriksena.bffagendador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BffagendadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffagendadorApplication.class, args);
	}

}
