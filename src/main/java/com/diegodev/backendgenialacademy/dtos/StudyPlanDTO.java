package com.diegodev.backendgenialacademy.dtos;

import java.util.Date;

public record StudyPlanDTO(
        String name,
        Date validUntil,
        Long universityId
) { }
