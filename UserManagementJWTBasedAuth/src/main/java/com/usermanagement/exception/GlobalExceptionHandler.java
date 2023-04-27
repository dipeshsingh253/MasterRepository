package com.usermanagement.exception;


import com.usermanagement.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException exception){

        Map<String,String> response = new HashMap<>();

        exception.getAllErrors().forEach((objectError -> {
            String fieldName = ((FieldError)objectError).getField();
            String message = objectError.getDefaultMessage();
            response.put(fieldName,message);
        }));

        return ResponseEntity.badRequest().body(response);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> defaultExceptionHandler(Exception e){


        return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage(), LocalDateTime.now()));

    }


}
