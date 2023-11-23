package com.example.utility;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoDataApp implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<User> users = new ArrayList<>();

        for (int i=51;i<100;i++){
            User user = new User();
            user.setFirstName("User"+i);
            user.setLastName("LastName"+i);
            user.setEmail("user"+i+"@mail.com");
            user.setPassword("password");
            user.setAddress("Address" + i);

            users.add(user);
        }


        userRepository.saveAll(users);
    }
}
