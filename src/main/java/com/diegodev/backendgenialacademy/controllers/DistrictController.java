package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.entities.DistrictEntity;
import com.diegodev.backendgenialacademy.services.DistrictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/districs")
@CrossOrigin
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/getAllByProvinceId/{id}")
    public List<DistrictEntity> GetAllByProvinceId(@PathVariable Long id) {
        return districtService.getAllByProvinceId(id);
    }
}
