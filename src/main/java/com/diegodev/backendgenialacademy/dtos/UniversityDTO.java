package com.diegodev.backendgenialacademy.dtos;

public record UniversityDTO (
        Long universityId,
        String name,
        String acronym,
        String type,
        String website,
        String imgUrl
){}
