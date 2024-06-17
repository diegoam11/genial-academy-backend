package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.entities.DistrictEntity;
import com.diegodev.backendgenialacademy.repositories.DistrictRepository;
import com.diegodev.backendgenialacademy.services.DistrictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    private DistrictRepository districtRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<DistrictEntity> getAllByProvinceId(Long provinceId) {
        return districtRepository.findAllByProvinceId(provinceId);
    }
}
