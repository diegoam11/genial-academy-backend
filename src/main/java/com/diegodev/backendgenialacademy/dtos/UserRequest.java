package com.diegodev.backendgenialacademy.dtos;

public record UserRequest(
        String username,
        String name,
        String lastname,
        String email,
        String password
) { }
