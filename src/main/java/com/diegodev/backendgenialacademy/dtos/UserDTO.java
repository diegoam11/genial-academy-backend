package com.diegodev.backendgenialacademy.dtos;

public record UserDTO(
        Long id,
        String name,
        String lastname,
        String username,
        String email
) {}
