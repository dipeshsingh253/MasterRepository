package com.user.UserService.controller;


import com.core.dto.ResponseTemplate;
import com.core.dto.SimpleMessageResponse;
import com.core.utility.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/basic")
public class BasicController {

    @Autowired
    private DateTimeUtility dateTimeUtility;
    @GetMapping("/dates")
    public ResponseEntity<ResponseTemplate> getSimpleDates(){
        ResponseTemplate response = new ResponseTemplate();
        response.setClassName(this.getClass().getSimpleName());
        response.setUri("/api/v1/basic/dates");
        response.setTimeStamp(LocalDateTime.now());
        response.setData("Dates has been logged in console.");

        dateTimeUtility.printTodayYesterdayTomorrowDate();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public SimpleMessageResponse getSimpleMessage(){
       return new SimpleMessageResponse("Hello World !!!",LocalDateTime.now());
    }
}
