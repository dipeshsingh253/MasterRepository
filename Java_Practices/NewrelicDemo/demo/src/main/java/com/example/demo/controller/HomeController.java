package com.example.demo.controller;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/greet")
    public String getGreetMessage(){

        logger.info("Inside the greet method of home controller");
        logger.debug("Inside hello greet in debug mode");
        logger.error("In case you see an error !!!");
        return "Hello World !!!";
    }

    @GetMapping("/status")
    public String getLoggerStatus(){
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(context);
        return context.getName() + "Status printed to console.";
    }

}
