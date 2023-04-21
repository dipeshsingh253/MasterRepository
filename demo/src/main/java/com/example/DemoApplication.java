package com.example;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner addDummyData(UserRepository userRepository){
		return args -> {
			List<User> users = new ArrayList<>();

			for (int i=100;i<150;i++){
				User user = new User();
				user.setFirstName("User"+i);
				user.setLastName("LastName"+i);
				user.setEmail("user"+i+"@mail.com");
				user.setPassword("password");
				user.setAddress("Address" + i);

				users.add(user);
			}


			userRepository.saveAll(users);
		};
	}

}
