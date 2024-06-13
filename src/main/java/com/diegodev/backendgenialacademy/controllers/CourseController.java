package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.CourseDTO;
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

    @GetMapping("/findAll")
    public List<CourseDTO> getAllCourses(){
        return courseService.findAll();
    }
    
    @PostMapping("/create")
    public CourseDTO create(@RequestBody CourseDTO course){
        return courseService.create(course);
    }
}
