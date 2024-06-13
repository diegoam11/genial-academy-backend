package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.entities.DepartmentEntity;
import com.diegodev.backendgenialacademy.repositories.DepartmentRepository;
import com.diegodev.backendgenialacademy.services.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentEntity create(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }
}
