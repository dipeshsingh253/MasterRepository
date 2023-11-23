package com.jwtsecurity.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtsecurity.dto.RestError;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws  IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ObjectMapper mapper = new ObjectMapper();
        RestError error = new RestError(HttpStatus.FORBIDDEN.toString(), "You do not have permission to access this resource");
        mapper.writeValue(response.getOutputStream(), error);

    }
}