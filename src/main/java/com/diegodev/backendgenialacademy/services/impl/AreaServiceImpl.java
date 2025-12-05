package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.requests.AreaReq;
import com.diegodev.backendgenialacademy.dtos.responses.AreaRes;
import com.diegodev.backendgenialacademy.entities.AreaEntity;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.repositories.AreaRepository;
import com.diegodev.backendgenialacademy.repositories.UniversityRepository;
import com.diegodev.backendgenialacademy.services.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;
    private final UniversityRepository universityRepository;

    public AreaServiceImpl(AreaRepository areaRepository, UniversityRepository universityRepository) {
        this.areaRepository = areaRepository;
        this.universityRepository = universityRepository;
    }

    @Override
    public AreaRes create(AreaReq areaReq) {
        // hola
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setName(areaReq.name());
        areaEntity.setCodArea(areaReq.codArea());
        areaEntity.setDescription(areaReq.description());
        UniversityEntity universityEntity = universityRepository.findById(areaReq.universityId()).orElseThrow();
        areaEntity.setUniversity(universityEntity);
        return mapToDTO(areaRepository.save(areaEntity));
    }

    @Override
    public List<AreaRes> findAll() {
        return areaRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<AreaRes> findByUniId(Long id) {
        return areaRepository.findByUniversityId(id).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public AreaRes mapToDTO(AreaEntity entity) {
        return new AreaRes(
                entity.getId(),
                entity.getName(),
                entity.getCodArea(),
                entity.getDescription(),
                entity.getUniversity().getId()
        );
    }
}
