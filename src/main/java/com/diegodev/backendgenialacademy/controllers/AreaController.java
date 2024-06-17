package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.requests.AreaReq;
import com.diegodev.backendgenialacademy.dtos.responses.AreaRes;
import com.diegodev.backendgenialacademy.services.AreaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping("/create")
    public AreaRes create(@RequestBody AreaReq areaReq) {
        return areaService.create(areaReq);
    }

    @GetMapping("/findAll")
    public List<AreaRes> findAll() {
        return areaService.findAll();
    }

}
