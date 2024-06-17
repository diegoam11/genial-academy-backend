package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.CareerRes;
import com.diegodev.backendgenialacademy.services.CareerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {
    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @GetMapping("/findAll")
    public List<CareerRes> findAll() {
        return careerService.findAll();
    }

    @PostMapping("/create")
    public CareerRes create(@RequestBody CareerRes careerRes) {
        return careerService.create(careerRes);
    }
}
