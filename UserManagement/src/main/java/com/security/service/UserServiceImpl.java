package com.security.service;

import com.security.dto.UserDto;
import com.security.entity.User;
import com.security.entity.UserDetail;
import com.security.exception.UserAlreadyExistsException;
import com.security.exception.UserDoesNotExistsException;
import com.security.repo.UserDetailRepo;
import com.security.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDetailRepo userDetailRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepo.findByEmail(username);

        if (optionalUser.isEmpty())
            throw new UsernameNotFoundException("username not found :"+username);

        return optionalUser.get();
    }

    @Override
    public void saveUser(UserDto userDto) {

        if (userRepo.existsByEmail(userDto.getEmail()))
            throw new UserAlreadyExistsException("user already exists with given email :"+userDto.getEmail());


        log.info("saving new user");

        User user = new User(userDto.getName(),userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        UserDetail userDetail = new UserDetail(userDto.getPhone(), userDto.getDesignation(),user);
        user.setUserDetail(userDetail);
        userRepo.save(user);

        userRepo.save(user);

    }

    @Override
    public void updateUser(Long userId,UserDto userDto) {

        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isEmpty())
            throw new UserDoesNotExistsException("user does not exists with given id :"+userId);

        log.info("updating user details");

        User user = optionalUser.get();

        user.getUserDetail().setDesignation(userDto.getDesignation());
        user.getUserDetail().setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepo.save(user);

    }

    @Override
    public UserDto getUserById(Long userId) {

        Optional<User> optionalUser = userRepo.findById(userId);

        if (optionalUser.isEmpty())
            throw new UserDoesNotExistsException("user does not exists with given id :"+userId);


        log.info("retrieving user details by user id for user id :"+userId);

        User user = optionalUser.get();

        return new UserDto(userId, user.getName(), user.getEmail(), user.getUserDetail().getPhone(),user.getPassword(),user.getUserDetail().getDesignation());
    }

    @Override
    public List<UserDto> getAllUsers() {

        log.info("retrieving all user details");

        return userRepo.findAll().stream().map(
                user -> {
                    return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUserDetail().getPhone(),user.getPassword(),user.getUserDetail().getDesignation());
                }
        ).toList();

    }


}
