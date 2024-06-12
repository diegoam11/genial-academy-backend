package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.UniversityDTO;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;

import java.util.List;

public interface UniversityService {
    UniversityEntity create(UniversityDTO universityDTO);
    UniversityEntity findById(Long id);
    List<UniversityDTO> findAll();
}
