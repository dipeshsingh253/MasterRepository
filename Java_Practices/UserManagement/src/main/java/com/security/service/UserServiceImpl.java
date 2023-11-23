package com.security.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.dto.UserDto;
import com.security.entity.User;
import com.security.entity.UserDetail;
import com.security.exception.UserAlreadyExistsException;
import com.security.exception.UserDoesNotExistsException;
import com.security.repo.UserDetailRepo;
import com.security.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;


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
                user -> new UserDto(user.getId(), user.getName(), user.getEmail(), user.getUserDetail().getPhone(),user.getPassword(),user.getUserDetail().getDesignation())
        ).toList();

    }


    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring(7);
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();

                User user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("username not found :"+username));

                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }

    }
}
