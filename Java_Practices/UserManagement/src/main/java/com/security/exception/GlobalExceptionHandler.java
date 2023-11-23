package com.security.exception;

import com.security.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> defaultExceptionHandler(Exception e, WebRequest request){
        return ResponseEntity.badRequest().body(new ErrorResponse(LocalDateTime.now(),e.getMessage(),request.getDescription(false)));
    }

}
