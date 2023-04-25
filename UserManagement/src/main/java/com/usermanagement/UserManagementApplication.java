package com.usermanagement;

import com.usermanagement.models.Designation;
import com.usermanagement.models.User;
import com.usermanagement.models.UserDetail;
import com.usermanagement.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UserManagementApplication {




    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }


    @Bean
    public ModelMapper provideModelMapper(){
        return new ModelMapper();
    }





}
