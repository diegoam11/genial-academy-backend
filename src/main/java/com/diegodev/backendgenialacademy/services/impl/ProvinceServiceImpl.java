package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.entities.ProvinceEntity;
import com.diegodev.backendgenialacademy.repositories.ProvinceRepository;
import com.diegodev.backendgenialacademy.services.ProvinceService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public List<ProvinceEntity> getAllByDeparmentId(Long departmentId) {
        return provinceRepository.findAllByDepartmentId(departmentId);
    }
}
