package com.springsecurity;

import com.springsecurity.dto.UserDto;
import com.springsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.springsecurity.entity.Designation.*;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService){
		return args -> {

			final String dummyPassword = "password";

			UserDto manager = new UserDto(null,"Mr. Manager","manager@mail.com","9265805191",dummyPassword, MANAGER);
			UserDto coManager = new UserDto(null,"Mr. CoManager","comanager@mail.com","8200923414",dummyPassword, COMANAGER);
			UserDto worker = new UserDto(null,"Mr. Worker","worker@mail.com","123456789",dummyPassword, WORKER);


			userService.registerUser(manager);
			userService.registerUser(coManager);
			userService.registerUser(worker);

		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
