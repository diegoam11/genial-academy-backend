package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.UniversityDTO;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;

public interface UniversityService {
    UniversityEntity createUniversity(UniversityDTO universityDTO);
}
