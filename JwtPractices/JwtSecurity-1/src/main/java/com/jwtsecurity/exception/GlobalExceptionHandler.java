package com.jwtsecurity.exception;


import com.jwtsecurity.dto.RestError;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import java.rmi.ServerException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<String> handleJwtSignatureException(SignatureException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid JWT signature");
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<RestError> handleServletException(ServletException e){
        return ResponseEntity.badRequest().body(new RestError(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
    }



    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestError> handleServletException(RuntimeException e){
        return ResponseEntity.badRequest().body(new RestError(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Log the exception
        ex.printStackTrace();

        // Return an error response
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }
}
