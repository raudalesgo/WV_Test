package com.cartmicroservices.cartservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cartmicroservices.cartservice.repository.CustomerRepository;

@SpringBootApplication
public class CartserviceApplication {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CartserviceApplication.class, args);
	}


}
