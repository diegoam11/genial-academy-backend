package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.entities.CourseEntity;
import com.diegodev.backendgenialacademy.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/getAll")
    public List<CourseEntity> getAllCourses(){
        return courseService.getAllCourses();
    }
    
    @PostMapping("/create")
    public CourseEntity createCourse(@RequestBody CourseEntity course){
        return courseService.createCourse(course);
    }
}
