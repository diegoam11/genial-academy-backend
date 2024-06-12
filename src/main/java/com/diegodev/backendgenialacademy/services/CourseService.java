package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.CourseDTO;
import com.diegodev.backendgenialacademy.entities.CourseEntity;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO create(CourseDTO course);
}
