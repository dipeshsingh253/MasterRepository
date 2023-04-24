package com.usermanagement.configs;

import com.usermanagement.models.Designation;
import com.usermanagement.models.User;
import com.usermanagement.models.UserDetail;
import com.usermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyDataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public CommandLineRunner addDummyUsers(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {

        return args -> {

            saveDummyUser("Mr. Manager","manager@mail.com","password","1234567890",Designation.MANAGER);
            saveDummyUser("Mr. CoManager","comanager@mail.com","password","7412589630",Designation.COMANAGER);
            saveDummyUser("Mr. Worker","worker@mail.com","password","7894561230",Designation.WORKER);

        };

    }

    private void saveDummyUser(String name, String email, String password, String phone, Designation designation){
        User user = new User(name,email,passwordEncoder.encode(password));
        UserDetail userDetail = new UserDetail(phone,designation,user);

        user.setUserDetail(userDetail);
        userRepository.save(user);
    }

}
