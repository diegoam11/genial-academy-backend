package com.diegodev.backendgenialacademy.dtos.responses;

import java.util.Date;

public record StudyPlanRes(
        String name,
        Date validUntil,
        Long universityId
) { }
