package com.security.service;


import com.security.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService{

    void saveUser(UserDto userDto);

    void updateUser(Long userId,UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();


    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
