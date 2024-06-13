package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.entities.DepartmentEntity;
import com.diegodev.backendgenialacademy.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public DepartmentEntity create(DepartmentEntity departmentEntity){
        return departmentService.create(departmentEntity);
    }
}
