package com.jwtsecurity.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {


    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok("Hello User");
    }


    @GetMapping("/manager")
    public ResponseEntity<String> manager(){
        return ResponseEntity.ok("only manager can access this");
    }

    @GetMapping("/comanager")
    public ResponseEntity<String> comanager(){
        return ResponseEntity.ok("only comanger can access this");
    }

    @GetMapping("/worker")
    public ResponseEntity<String> worker(){
        return ResponseEntity.ok("only worker can access this");
    }


}
