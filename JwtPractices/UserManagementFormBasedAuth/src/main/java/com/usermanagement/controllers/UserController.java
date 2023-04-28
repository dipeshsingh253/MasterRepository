package com.usermanagement.controllers;

import com.usermanagement.dto.UserDto;
import com.usermanagement.entity.Designation;
import com.usermanagement.services.UserService;
import com.usermanagement.services.impls.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id, Model model){
        UserDto userDto = userService.getUserById(id);
        model.addAttribute("user",userDto);
        return "edituser";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid @ModelAttribute("user")UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "edituser";
        }
        userService.updateUser(id,userDto);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserDto());
        model.addAttribute("designations", Designation.values());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user")UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.registerUser(userDto);

        return "redirect:/users";
    }


}
