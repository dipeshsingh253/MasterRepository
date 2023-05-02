package com.springsecurity.service;

import com.springsecurity.dto.UserDto;
import com.springsecurity.entity.User;
import com.springsecurity.entity.UserDetail;
import com.springsecurity.exception.UserAlreadyExistsException;
import com.springsecurity.exception.UserNotFoundException;
import com.springsecurity.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(Authentication authentication) {

        if (userRepository.existsByEmail(authentication.getName())){
            return "Log in successful";
        }
        throw new UserNotFoundException("user not found");
    }

    @Override
    public void registerUser(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())){
            throw new UserAlreadyExistsException("user email already exist");
        }

        log.info("saving a new user to database");
        userRepository.save(dtoToEntity(userDto));

    }

    @Override
    public void updateUser(Integer id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user email not found"));

        log.info("updating user with user id : {}",id);

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.getUserDetail().setDesignation(userDto.getDesignation());
        user.getUserDetail().setPhone(userDto.getPhone());

        userRepository.save(user);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return entityToDto(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user email not found")));
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(this::entityToDto).toList();
    }

    private User dtoToEntity(final UserDto userDto){
        final User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        final UserDetail userDetail = new UserDetail(userDto.getPhone(), userDto.getDesignation(),user);
        user.setUserDetail(userDetail);
        return user;
    }

    private UserDto entityToDto(final User user){
        return UserDto.builder().id(user.getId())
                .phone(user.getUserDetail().getPhone())
                .designation(user.getUserDetail().getDesignation())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .build();
    }


}
