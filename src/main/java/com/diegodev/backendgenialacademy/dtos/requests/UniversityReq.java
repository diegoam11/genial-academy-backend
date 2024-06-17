package com.diegodev.backendgenialacademy.dtos.requests;

public record UniversityReq(
        String name,
        String acronym,
        String type,
        String website,
        String imgUrl
){}
