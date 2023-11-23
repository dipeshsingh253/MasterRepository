package com.jwtsecurity.service;


import com.jwtsecurity.dto.UserDto;
import com.jwtsecurity.entity.User;

import java.util.List;

public interface UserService {


    User registerUser(UserDto userDto);

    void removeUserById(Integer id);

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();


}
