package com.usermanagement.controllers;

import com.usermanagement.payloads.UserDto;
import com.usermanagement.services.UserService;
import com.usermanagement.services.impls.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(Model model) {
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("users", userDtos);

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userRole = null;

        for (GrantedAuthority authority:userDetails.getAuthorities())
                userRole = authority.getAuthority();

        model.addAttribute("userRole",userRole);
        return "index";
    }


    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id,Model model){
        UserDto userDto = userService.getUserById(id);
        System.out.println(userDto.getName());
        model.addAttribute("user",userDto);
        return "edituser";
    }




}
