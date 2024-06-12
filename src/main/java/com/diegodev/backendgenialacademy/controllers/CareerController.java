package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.CareerDTO;
import com.diegodev.backendgenialacademy.entities.CareerEntity;
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
    public List<CareerDTO> findAll() {
        return careerService.findAll();
    }

    @PostMapping("/create")
    public CareerDTO create(@RequestBody CareerDTO careerDTO) {
        return careerService.create(careerDTO);
    }
}
