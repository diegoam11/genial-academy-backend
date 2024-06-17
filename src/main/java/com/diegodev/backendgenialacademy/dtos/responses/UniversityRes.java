package com.diegodev.backendgenialacademy.dtos.responses;

public record UniversityRes(
        Long id,
        String name,
        String acronym,
        String type,
        String website,
        String imgUrl
){}
