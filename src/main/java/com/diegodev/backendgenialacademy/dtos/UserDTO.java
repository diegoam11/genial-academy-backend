package com.diegodev.backendgenialacademy.dtos;

public record UserDTO(
        Long id,
        String username,
        String name,
        String lastname,
        String email
) {}
