package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.entities.DepartmentEntity;
import com.diegodev.backendgenialacademy.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@CrossOrigin
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
