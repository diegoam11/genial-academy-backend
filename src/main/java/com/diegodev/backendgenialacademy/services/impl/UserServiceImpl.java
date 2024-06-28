package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.responses.UserRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;
import com.diegodev.backendgenialacademy.entities.UserEntity;
import com.diegodev.backendgenialacademy.repositories.UserRepository;
import com.diegodev.backendgenialacademy.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserRes> findByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            UserEntity userPresent = user.get();
            return Optional.of(new UserRes(
                    userPresent.getId(),
                    userPresent.getName(),
                    userPresent.getLastname(),
                    userPresent.getUsername(),
                    userPresent.getEmail()
            ));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserRes> findByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            UserEntity userPresent = user.get();
            return Optional.of(new UserRes(
                    userPresent.getId(),
                    userPresent.getName(),
                    userPresent.getLastname(),
                    userPresent.getUsername(),
                    userPresent.getEmail()
            ));
        }
        return Optional.empty();
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
