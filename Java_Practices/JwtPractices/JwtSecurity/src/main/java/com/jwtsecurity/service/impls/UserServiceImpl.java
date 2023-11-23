package com.jwtsecurity.service.impls;

import com.jwtsecurity.dto.UserDto;
import com.jwtsecurity.entity.User;
import com.jwtsecurity.entity.UserDetail;
import com.jwtsecurity.repository.UserDetailRepository;
import com.jwtsecurity.repository.UserRepository;
import com.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public User registerUser(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        UserDetail detail = new UserDetail(userDto.getPhone(),userDto.getDesignation(),user);

        user.setUserDetail(detail);

        return userRepository.save(user);

    }

    @Override
    public void removeUserById(Integer id) {

        userRepository.delete(userRepository.findById(id).orElseThrow());

    }

    @Override
    public UserDto getUserById(Integer id) {

        return userToUserDto(userRepository.findById(id).orElseThrow());

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::userToUserDto).toList();
    }

    private UserDto userToUserDto(final User user){
        return new UserDto(
                user.getId(), user.getEmail(), user.getName(), user.getPassword(), user.getUserDetail().getPhone(),user.getUserDetail().getDesignation()
        );
    }

}
