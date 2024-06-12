package com.diegodev.backendgenialacademy.dtos;

public record UserDetailDTO(
        String phone,
        String typeSchool,
        Long districtId,
        Long careerId,
        Long userId
) { }
