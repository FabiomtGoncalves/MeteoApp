package com.example.meteoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.meteoapp.repository.IUserRepository;

@SpringBootApplication
public class SpringdatajpaApplication {
	
	IUserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner userRegister(IUserRepository userRepository) {
		return args -> {
			
		};
	}
	
	@Bean
	public CommandLineRunner userLogin(IUserRepository userRepository) {
		return args -> {
			//List<User> usersByEmailAndPass = userRepository.findByEmailAndPassword("", "");
			//System.out.println("Returned data: " + usersByEmailAndPass.toString());
		};
	}
	
	@Bean
	public CommandLineRunner addFavorite(IUserRepository employeeRepository) {
		return args -> {
			
		};
	}
	
}
