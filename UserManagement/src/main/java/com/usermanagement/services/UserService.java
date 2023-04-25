package com.usermanagement.services;


import com.usermanagement.payloads.UserDto;

import java.util.List;

public interface UserService {

    void registerUser(UserDto userDto);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    void updateUser(Integer id,UserDto userDto);

    void removeUser(Integer id);

}
