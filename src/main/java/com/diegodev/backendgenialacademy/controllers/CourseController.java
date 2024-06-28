package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.CourseRes;
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
    public List<CourseRes> findAll(){
        return courseService.findAll();
    }
    
    @PostMapping("/create")
    public CourseRes create(@RequestBody CourseRes course){
        return courseService.create(course);
    }
}
