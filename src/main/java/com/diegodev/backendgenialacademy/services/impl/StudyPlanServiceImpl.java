package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.StudyPlanDTO;
import com.diegodev.backendgenialacademy.entities.StudyPlanEntity;
import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import com.diegodev.backendgenialacademy.repositories.StudyPlanRepository;
import com.diegodev.backendgenialacademy.repositories.UniversityRepository;
import com.diegodev.backendgenialacademy.services.StudyPlanService;
import org.springframework.stereotype.Service;

@Service
public class StudyPlanServiceImpl implements StudyPlanService {

    private final StudyPlanRepository studyPlanRepository;
    private final UniversityRepository universityRepository;

    public StudyPlanServiceImpl(StudyPlanRepository studyPlanRepository, UniversityRepository universityRepository) {
        this.studyPlanRepository = studyPlanRepository;
        this.universityRepository = universityRepository;
    }

    @Override
    public StudyPlanDTO createStudyPlan(StudyPlanDTO studyPlanDTO) {
        StudyPlanEntity studyPlanEntity = new StudyPlanEntity();
        studyPlanEntity.setName(studyPlanDTO.name());
        studyPlanEntity.setValidUntil(studyPlanDTO.validUntil());
        UniversityEntity university = universityRepository.findById(studyPlanDTO.universityId()).orElseThrow();
        studyPlanEntity.setUniversity(university);
        return mapToDTO(studyPlanRepository.save(studyPlanEntity));
    }

    public StudyPlanDTO mapToDTO(StudyPlanEntity entity) {
        return new StudyPlanDTO(
                entity.getName(),
                entity.getValidUntil(),
                entity.getUniversity().getUniversityId()
        );
    }
}
