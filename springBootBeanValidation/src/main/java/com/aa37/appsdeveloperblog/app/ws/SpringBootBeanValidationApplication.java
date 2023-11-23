package com.aa37.appsdeveloperblog.app.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aa37.appsdeveloperblog.app.ws.entity.Users;
import com.aa37.appsdeveloperblog.app.ws.repository.UserRepository;

@SpringBootApplication
public class SpringBootBeanValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanValidationApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(UserRepository userRepository) throws Exception {
		
		return (String[] args) -> {
			Users u1= new Users("Bob","bob@domain.com");
			Users u2= new Users("Jenny","jenny@domain.com");
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.findAll().forEach(System.out::println);
			
		};
		
	}

}
