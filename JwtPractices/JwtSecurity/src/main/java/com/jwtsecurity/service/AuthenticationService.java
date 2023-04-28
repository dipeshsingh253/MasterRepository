package com.jwtsecurity.service;

import com.jwtsecurity.dto.AuthenticationRequest;
import com.jwtsecurity.dto.AuthenticationResponse;
import com.jwtsecurity.dto.RegisterRequest;
import com.jwtsecurity.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AuthenticationService {

    AuthenticationResponse register(UserDto userDto);
    AuthenticationResponse authenticate(AuthenticationRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
