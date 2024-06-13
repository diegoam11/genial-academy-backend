package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.entities.ProvinceEntity;

import java.util.List;

public interface ProvinceService {
    List<ProvinceEntity> getAllByDeparmentId(Long departmentId);
}
