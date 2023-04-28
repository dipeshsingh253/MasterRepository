package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);


    void addRoleToUser(String username,String role);

    User getUser(String username);

    List<User> getUsers();

}
