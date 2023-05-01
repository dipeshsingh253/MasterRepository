package com.security.controller;


import com.security.dto.UserDto;
import com.security.entity.User;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PostMapping("/save/user")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.ok("User Saved Successfully");
    }

    @PutMapping("/edit/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id,@RequestBody UserDto userDto){

        userService.updateUser(id,userDto);

        return ResponseEntity.ok("User Updated Successfully");
    }

}
