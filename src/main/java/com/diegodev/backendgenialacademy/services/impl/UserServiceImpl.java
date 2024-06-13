package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.UserDTO;
import com.diegodev.backendgenialacademy.dtos.UserLogin;
import com.diegodev.backendgenialacademy.dtos.UserRequest;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import com.diegodev.backendgenialacademy.exceptions.AuthenticationException;
import com.diegodev.backendgenialacademy.repositories.UserRepository;
import com.diegodev.backendgenialacademy.services.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findByUsername(String username) {
        UserEntity userFound = userRepository.findByUsername(username);
        return new UserDTO(
                userFound.getUserId(),
                userFound.getName(),
                userFound.getLastname(),
                userFound.getUsername(),
                userFound.getEmail()
        );
    }

    @Override
    public UserDTO createUser(UserRequest userRequest) {
        UserEntity savedUser = userRepository.save(mapReqToEntity(userRequest));
        return new UserDTO(
                savedUser.getUserId(),
                savedUser.getName(),
                savedUser.getLastname(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserLogin userLogin(UserLogin userLogin) {
        UserEntity userEntity = userRepository.findByUsername(userLogin.username());
        if (userEntity == null || !userEntity.getPassword().equals(userLogin.password())) {
            throw new AuthenticationException("Invalid username or password");
        }
        return userLogin;
    }


    public UserEntity mapReqToEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.name());
        userEntity.setLastname(userRequest.lastname());
        userEntity.setUsername(userRequest.username());
        userEntity.setEmail(userRequest.email());
        userEntity.setPassword(userRequest.password());
        return userEntity;
    }
}
