package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.entities.CourseEntity;
import com.diegodev.backendgenialacademy.repositories.CourseRepository;
import com.diegodev.backendgenialacademy.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseEntity createCourse(CourseEntity course) {
        return courseRepository.save(course);
    }
}
