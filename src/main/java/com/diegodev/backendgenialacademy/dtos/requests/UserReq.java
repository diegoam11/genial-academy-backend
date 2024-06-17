package com.diegodev.backendgenialacademy.dtos.requests;

import com.diegodev.backendgenialacademy.dtos.Role;

public record UserReq(
        String username,
        String name,
        String lastname,
        String email,
        String password,
        Role role
) { }
