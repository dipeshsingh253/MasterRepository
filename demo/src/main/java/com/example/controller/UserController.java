package com.example.controller;


import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody User user){

        userService.createUser(user);

        return ResponseEntity.ok("user created");
    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id,@RequestBody User user){

        userService.updateUser(id,user);

        return ResponseEntity.ok("user updated");
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    
//     ?size=10&page=0&sort=id,asc

//    @GetMapping("/pageble")
//    public ResponseEntity<Page<User>> getUserWithPagination(Pageable pageable){
//        return ResponseEntity.ok(userService.findAllUserWithPagination(pageable));
//    }

}


