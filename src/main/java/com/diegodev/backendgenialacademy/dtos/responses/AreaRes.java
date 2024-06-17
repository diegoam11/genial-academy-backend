package com.diegodev.backendgenialacademy.dtos.responses;

public record AreaRes(
        Long id,
        String name,
        String codArea,
        String description,
        Long universityId
) {
}
