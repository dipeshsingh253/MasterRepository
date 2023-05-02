package com.springsecurity.controller;


import com.springsecurity.dto.ResponseMessage;
import com.springsecurity.dto.UserDto;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<ResponseMessage> registerUser(@RequestBody UserDto userDto){

        userService.registerUser(userDto);

        return ResponseEntity.ok(new ResponseMessage("User Registered Successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateUser(@PathVariable("id") Integer id,@RequestBody UserDto userDto){
        userService.updateUser(id,userDto);
        return ResponseEntity.ok(new ResponseMessage("User Updated Successfully"));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginHandler(Authentication authentication)  {
        String message = userService.login(authentication);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
