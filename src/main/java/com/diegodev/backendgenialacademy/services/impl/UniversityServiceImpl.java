package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.UniversityDTO;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.repositories.UniversityRepository;
import com.diegodev.backendgenialacademy.services.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public UniversityEntity create(UniversityDTO universityDTO) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setName(universityDTO.name());
        universityEntity.setAcronym(universityDTO.acronym());
        universityEntity.setType(universityDTO.type());
        universityEntity.setWebsite(universityDTO.website());
        universityEntity.setImgUrl(universityDTO.imgUrl());
        return universityRepository.save(universityEntity);
    }

    @Override
    public UniversityEntity findById(Long id){
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public List<UniversityDTO> findAll(){
        return universityRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UniversityDTO mapToDTO(UniversityEntity entity) {
        return new UniversityDTO(
                entity.getUniversityId(),
                entity.getName(),
                entity.getAcronym(),
                entity.getType(),
                entity.getWebsite(),
                entity.getImgUrl()
        );
    }
}
