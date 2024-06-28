package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.UserRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;

import java.util.Optional;

public interface UserService {
    Optional<UserRes> findByUsername(String username);
    Optional<UserRes> findByEmail(String email);
    UserRes createUser(UserReq userReq);
    UserLoginReq userLogin(UserLoginReq userLoginReq);
}
