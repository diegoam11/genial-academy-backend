package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.entities.ProvinceEntity;
import com.diegodev.backendgenialacademy.services.ProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provinces")
@CrossOrigin
public class ProvinceController {

    private final ProvinceService provinceService;

    public ProvinceController(final ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("/findAllByDepartmentId/{id}")
    public List<ProvinceEntity> getByDepartmentId(@PathVariable Long id) {
        return provinceService.getAllByDeparmentId(id);
    }
}
