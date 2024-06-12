package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.entities.CourseEntity;

import java.util.List;

public interface CourseService {
    List<CourseEntity> getAllCourses();
    CourseEntity createCourse(CourseEntity course);
}
