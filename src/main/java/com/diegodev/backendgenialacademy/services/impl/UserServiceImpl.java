package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.UniversityDTO;
import com.diegodev.backendgenialacademy.dtos.UserDTO;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.entities.UserEntity;
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
                userFound.getUsername(),
                userFound.getName(),
                userFound.getLastname(),
                userFound.getEmail()
        );
    }

    @Override
    public UserDTO createUser(UserEntity user) {
        UserEntity savedUser = userRepository.save(user);
        return new UserDTO(
                savedUser.getUserId(),
                savedUser.getUsername(),
                savedUser.getName(),
                savedUser.getLastname(),
                savedUser.getEmail()
        );
    }
}
