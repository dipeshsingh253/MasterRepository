package com.usermanagement.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usermanagement.dto.RestError;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component("customAuthenticationEntryPoint")
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException {

        // Create your custom response body as an object or a string message
        RestError re = new RestError(HttpStatus.UNAUTHORIZED.toString(), "Authentication failed");

        // Create a ResponseEntity object with your custom response body
        ResponseEntity<Object> entity = new ResponseEntity<>(re, HttpStatus.UNAUTHORIZED);

        // Write the response to the HttpServletResponse object
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        OutputStream responseStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(responseStream, entity);
        responseStream.flush();
    }
}