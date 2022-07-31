package com.ecom.SpringBoot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@OpenAPIDefinition
@EnableWebMvc
public class EcomSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomSpringBootApplication.class, args);
	}

}
