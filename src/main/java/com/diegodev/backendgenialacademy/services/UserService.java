package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.UserDTO;
import com.diegodev.backendgenialacademy.entities.UserEntity;

public interface UserService {
    UserDTO findByUsername(String username);
    UserDTO createUser(UserEntity user);
}