package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.UniversityDTO;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.services.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/create")
    public UniversityEntity createUniversity(@RequestBody UniversityDTO universityDTO) {
        return universityService.create(universityDTO);
    }

    @GetMapping("/findById/{id}")
    public UniversityEntity createUniversity(@PathVariable Long id) {
        return universityService.findById(id);
    }

    @GetMapping("/findAll")
    public List<UniversityDTO> createUniversity() {
        return universityService.findAll();
    }
}
