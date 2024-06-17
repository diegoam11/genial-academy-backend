package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.responses.CareerRes;
import com.diegodev.backendgenialacademy.entities.CareerEntity;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.repositories.CareerRepository;
import com.diegodev.backendgenialacademy.repositories.UniversityRepository;
import com.diegodev.backendgenialacademy.services.CareerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareerServiceImpl implements CareerService {
    private final CareerRepository careerRepository;
    private final UniversityRepository universityRepository;

    public CareerServiceImpl(CareerRepository careerRepository, UniversityRepository universityRepository) {
        this.careerRepository = careerRepository;
        this.universityRepository = universityRepository;
    }

    @Override
    public List<CareerRes> findAll() {
        return careerRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CareerRes create(CareerRes careerRes) {
        CareerEntity careerEntity = new CareerEntity();
        careerEntity.setName(careerRes.name());
        UniversityEntity university = universityRepository.findById(careerRes.universityId()).orElseThrow();
        careerEntity.setUniversity(university);
        return mapToDTO(careerRepository.save(careerEntity));
    }

    public CareerRes mapToDTO(CareerEntity entity) {
        return new CareerRes(
                entity.getId(),
                entity.getName(),
                entity.getUniversity().getId()
        );
    }
}
