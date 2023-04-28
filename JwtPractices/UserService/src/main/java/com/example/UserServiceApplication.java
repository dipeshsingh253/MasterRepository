package com.example;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Goku Singh", "goku", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Naruto Uzumaki", "naruto", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ben Tenyson", "ben", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Monkey D Fuffy", "luffy", "1234", new ArrayList<>()));

			userService.addRoleToUser("ben", "ROLE_USER");
			userService.addRoleToUser("naruto", "ROLE_MANAGER");
			userService.addRoleToUser("goku", "ROLE_ADMIN");
			userService.addRoleToUser("luffy", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("luffy", "ROLE_ADMIN");
			userService.addRoleToUser("luffy", "ROLE_USER");
		};
	}

}
