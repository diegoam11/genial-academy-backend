package com.diegodev.backendgenialacademy.dtos.responses;

public record CourseRes(
        Long id,
        String name,
        String description,
        Long studyPlanId
) { }
