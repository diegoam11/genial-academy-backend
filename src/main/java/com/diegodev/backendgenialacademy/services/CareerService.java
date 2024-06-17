package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.CareerRes;

import java.util.List;

public interface CareerService {
    List<CareerRes> findAll();
    CareerRes create(CareerRes careerRes);
}
