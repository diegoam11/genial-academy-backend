package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.CareerDTO;
import com.diegodev.backendgenialacademy.entities.CareerEntity;

import java.util.List;

public interface CareerService {
    List<CareerDTO> findAll();
    CareerDTO create(CareerDTO careerDTO);
}
