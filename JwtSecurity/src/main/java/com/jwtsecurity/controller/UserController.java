package com.jwtsecurity.controller;


import com.jwtsecurity.dto.ResponseMessage;
import com.jwtsecurity.dto.UserDto;
import com.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseMessage> registerUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(new ResponseMessage("user created successfully"));
    }

}
