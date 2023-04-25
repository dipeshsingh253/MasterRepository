package com.usermanagement.controllers;

import com.usermanagement.payloads.UserDto;
import com.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserEditController {

    @Autowired
    private UserService userService;

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id, Model model){
        UserDto userDto = userService.getUserById(id);
        model.addAttribute("user",userDto);
        return "edituser";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute("user")UserDto userDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "/edit/"+id;
        }
        userService.updateUser(id,userDto);

        return "redirect:/";
    }


}
