package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.UserDetailRes;
import com.diegodev.backendgenialacademy.entities.UserDetailEntity;

public interface UserDetailService {
    UserDetailEntity findByUserId(Long userId);
    UserDetailEntity addDetail(UserDetailRes userDetailRes);
}
