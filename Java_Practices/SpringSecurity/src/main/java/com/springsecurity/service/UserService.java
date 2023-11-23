package com.springsecurity.service;


import com.springsecurity.dto.UserDto;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface UserService {

    void registerUser(UserDto userDto);

    void updateUser(Integer id,UserDto userDto);

    UserDto getUserById(Integer id);

    List<UserDto> getUsers();

    String login(Authentication authentication);
}
