package com.springtutuorial.springmongo.controller;


import com.springtutuorial.springmongo.model.User;
import com.springtutuorial.springmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;



@RestController
@RequestMapping("/api/v1/users")
public class UserRest {

    @Autowired
    private UserService userService;



    /**
     * Create a new user
     * @param user new user details
     * @return ResponseEntity of user
     * @throws URISyntaxException
     */
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException, NoSuchMethodException {
        return ResponseEntity.created(new URI("/api/v1/users")).body(userService.createUser(user));
    }


    /**
     * Get all users
     * @return ResponseEntity of List Of Users
     */
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() throws NoSuchMethodException {

        return ResponseEntity.ok(userService.findAllUsers());
    }


    /**
     * Get user by id
     * @param id user id to get user details
     * @return ResponseEntity of user
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) throws NoSuchMethodException {
        return ResponseEntity.ok(userService.findUserById(id));
    }

}
