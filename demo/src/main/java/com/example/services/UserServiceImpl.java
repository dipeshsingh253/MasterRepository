package com.example.services;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void createUser(User user) {

        repository.save(user);

    }

    @Override
    public void updateUser(Integer id, User user) {

        repository.save(user);

    }

    @Override
    public List<User> getAllUsers() {

        return repository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));

    }

    @Override
    public User getUserById(Integer id) {

        return repository.findById(id).orElseThrow();

    }

//    @Override
//    public Page<User> findAllUserWithPagination(Pageable pageable) {
//        return repository.findAllUsersWithPagination(pageable);
//    }
}
