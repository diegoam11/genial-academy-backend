package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.entities.DistrictEntity;

import java.util.List;

public interface DistrictService {
    List<DistrictEntity> getAllByProvinceId(Long provinceId);
}
