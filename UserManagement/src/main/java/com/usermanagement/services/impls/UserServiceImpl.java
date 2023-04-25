package com.usermanagement.services.impls;

import com.usermanagement.models.User;
import com.usermanagement.models.UserDetail;
import com.usermanagement.payloads.UserDto;
import com.usermanagement.repositories.UserRepository;
import com.usermanagement.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDto userDto) {
        User user = new User(userDto.getName(),userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        UserDetail userDetail = new UserDetail(userDto.getPhone(), userDto.getDesignation(),user);
        user.setUserDetail(userDetail);
        userRepository.save(user);
    }

    @Override
    public UserDto getUserById(Integer id) {

        User user = userRepository.findById(id).orElseThrow();

        return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getUserDetail().getPhone(),user.getPassword(),user.getUserDetail().getDesignation());

    }

    @Override
    public List<UserDto> getAllUsers() {

        return userRepository.findAll().stream().map((user)-> {
            return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getUserDetail().getPhone(),user.getPassword(),user.getUserDetail().getDesignation());
        }).toList();

    }

    @Override
    public void updateUser(Integer id, UserDto userDto) {

        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.getUserDetail().setPhone(userDto.getPhone());
        user.getUserDetail().setDesignation(userDto.getDesignation());

        userRepository.save(user);

    }

    @Override
    public void removeUser(Integer id) {
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }


}
