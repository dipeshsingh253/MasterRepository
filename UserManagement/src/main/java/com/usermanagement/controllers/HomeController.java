package com.usermanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/users";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
