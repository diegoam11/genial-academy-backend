package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.requests.UniversityReq;
import com.diegodev.backendgenialacademy.dtos.responses.UniversityRes;
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
    public UniversityRes create(UniversityReq universityReq) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setName(universityReq.name());
        universityEntity.setAcronym(universityReq.acronym());
        universityEntity.setType(universityReq.type());
        universityEntity.setWebsite(universityReq.website());
        universityEntity.setImgUrl(universityReq.imgUrl());
        return mapToDTO(universityRepository.save(universityEntity));
    }

    @Override
    public UniversityRes findById(Long id){
        return mapToDTO(universityRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UniversityRes> findAll(){
        return universityRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UniversityRes mapToDTO(UniversityEntity entity) {
        return new UniversityRes(
                entity.getId(),
                entity.getName(),
                entity.getAcronym(),
                entity.getType(),
                entity.getWebsite(),
                entity.getImgUrl()
        );
    }
}
