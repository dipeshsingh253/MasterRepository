package com.springtutuorial.springmongo.service;


import com.springtutuorial.springmongo.model.User;
import com.springtutuorial.springmongo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {

        return userRepo.findAll();

    }

    public User findUserById(String id) {

        return userRepo.findById(id).orElseThrow();

    }
}
