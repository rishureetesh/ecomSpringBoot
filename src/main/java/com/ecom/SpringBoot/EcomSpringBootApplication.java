package com.ecom.SpringBoot;

import com.ecom.SpringBoot.model.User;
import com.ecom.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcomSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomSpringBootApplication.class, args);
	}

}
