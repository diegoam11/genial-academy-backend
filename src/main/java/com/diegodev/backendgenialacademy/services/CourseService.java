package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.CourseRes;

import java.util.List;

public interface CourseService {
    List<CourseRes> findAll();
    CourseRes create(CourseRes course);
}
