package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.UserRes;
import com.diegodev.backendgenialacademy.dtos.requests.UserLoginReq;
import com.diegodev.backendgenialacademy.dtos.requests.UserReq;

public interface UserService {
    UserRes findByUsername(String username);
    UserRes createUser(UserReq userReq);
    UserLoginReq userLogin(UserLoginReq userLoginReq);
}
