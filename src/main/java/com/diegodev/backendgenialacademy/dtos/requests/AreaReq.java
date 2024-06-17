package com.diegodev.backendgenialacademy.dtos.requests;

public record AreaReq(
        String name,
        String codArea,
        String description,
        Long universityId
) {
}
