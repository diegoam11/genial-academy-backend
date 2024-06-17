package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.responses.UserRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;
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
    public UserRes findByUsername(String username) {
        return null;
    }

    @Override
    public UserRes createUser(UserReq userReq) {
        UserEntity savedUser = userRepository.save(mapReqToEntity(userReq));
        return new UserRes(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getLastname(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    @Override
    public UserLoginReq userLogin(UserLoginReq userLoginReq) {
        return null;
    }

    public UserEntity mapReqToEntity(UserReq userReq) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userReq.name());
        userEntity.setLastname(userReq.lastname());
        userEntity.setUsername(userReq.username());
        userEntity.setEmail(userReq.email());
        userEntity.setPassword(userReq.password());
        return userEntity;
    }
}
