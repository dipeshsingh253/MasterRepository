package com.usermanagement.controllers;

import com.usermanagement.payloads.UserDto;
import com.usermanagement.services.UserService;
import com.usermanagement.services.impls.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("users", userDtos);

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userRole = null;
        String userEmail = userDetails.getUsername();
        for (GrantedAuthority authority:userDetails.getAuthorities())
                userRole = authority.getAuthority();

        model.addAttribute("userRole",userRole);
        model.addAttribute("userEmail",userEmail);
        return "users";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Integer id){

        userService.removeUser(id);

        return "redirect:/";
    }
    @GetMapping("/users/user/{id}")
    public String showUserDetails(@PathVariable("id") Integer id, Model model){

        UserDto userDto = userService.getUserById(id);
        model.addAttribute("user",userDto);

        return "user";

    }

}
