package com.diegodev.backendgenialacademy.dtos.responses;

public record UserDetailRes(
        String phone,
        String typeSchool,
        Long districtId,
        Long careerId,
        Long userId
) { }
