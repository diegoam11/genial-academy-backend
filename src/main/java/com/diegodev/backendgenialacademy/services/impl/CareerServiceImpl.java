package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.CareerDTO;
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
    public List<CareerDTO> findAll() {
        return careerRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CareerDTO create(CareerDTO careerDTO) {
        CareerEntity careerEntity = new CareerEntity();
        careerEntity.setName(careerDTO.name());
        UniversityEntity university = universityRepository.findById(careerDTO.universityId()).orElseThrow();
        careerEntity.setUniversity(university);
        return mapToDTO(careerRepository.save(careerEntity));
    }

    public CareerDTO mapToDTO(CareerEntity entity) {
        return new CareerDTO(
                entity.getCareerId(),
                entity.getName(),
                entity.getUniversity().getUniversityId()
        );
    }
}
