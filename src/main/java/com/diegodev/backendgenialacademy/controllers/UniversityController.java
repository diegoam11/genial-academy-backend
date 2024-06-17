package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.requests.UniversityReq;
import com.diegodev.backendgenialacademy.dtos.responses.UniversityRes;
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
    public UniversityRes create(@RequestBody UniversityReq universityReq) {
        return universityService.create(universityReq);
    }

    @GetMapping("/findById/{id}")
    public UniversityRes findById(@PathVariable Long id) {
        return universityService.findById(id);
    }

    @GetMapping("/findAll")
    public List<UniversityRes> findAll() {
        return universityService.findAll();
    }
}
