package com.security.service;


import com.security.dto.UserDto;

import java.util.List;

public interface UserService{

    void saveUser(UserDto userDto);

    void updateUser(Long userId,UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();


}
