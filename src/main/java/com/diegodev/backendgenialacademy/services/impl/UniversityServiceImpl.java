package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.UniversityDTO;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.repositories.UniversityRepository;
import com.diegodev.backendgenialacademy.services.UniversityService;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public UniversityEntity createUniversity(UniversityDTO universityDTO) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setName(universityDTO.name());
        universityEntity.setAcronym(universityDTO.acronym());
        universityEntity.setType(universityDTO.type());
        universityEntity.setWebsite(universityDTO.website());
        return universityRepository.save(universityEntity);
    }
}
