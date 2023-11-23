package com.security;

import com.security.dto.UserDto;
import com.security.entity.Designation;
import com.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserManagementApplication {


	public static void main(String[] args) {

		SpringApplication.run(UserManagementApplication.class, args);

	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	public CommandLineRunner commandLineRunner(UserService userService){
		return args -> {

			final String dummyPassword = "password";

			UserDto manager = new UserDto(null,"Mr. Manager","manager@mail.com","9265805191",dummyPassword, Designation.MANAGER);
			UserDto coManager = new UserDto(null,"Mr. CoManager","comanager@mail.com","8200923414",dummyPassword, Designation.MANAGER);
			UserDto worker = new UserDto(null,"Mr. Worker","worker@mail.com","123456789",dummyPassword, Designation.MANAGER);


			userService.saveUser(manager);
			userService.saveUser(coManager);
			userService.saveUser(worker);

		};
	}

}
