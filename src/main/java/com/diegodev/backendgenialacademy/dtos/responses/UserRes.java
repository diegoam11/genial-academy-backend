package com.diegodev.backendgenialacademy.dtos.responses;

public record UserRes(
        Long id,
        String name,
        String lastname,
        String username,
        String email
) {}
