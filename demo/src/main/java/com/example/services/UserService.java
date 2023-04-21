package com.example.services;

import com.example.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void createUser(User user);
    void updateUser(Integer id, User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

//    Page<User> findAllUserWithPagination(Pageable pageable);

}
