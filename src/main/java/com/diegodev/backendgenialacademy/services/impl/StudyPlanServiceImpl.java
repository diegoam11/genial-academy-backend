package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.responses.StudyPlanRes;
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
    public StudyPlanRes createStudyPlan(StudyPlanRes studyPlanRes) {
        StudyPlanEntity studyPlanEntity = new StudyPlanEntity();
        studyPlanEntity.setName(studyPlanRes.name());
        studyPlanEntity.setValidUntil(studyPlanRes.validUntil());
        UniversityEntity university = universityRepository.findById(studyPlanRes.universityId()).orElseThrow();
        studyPlanEntity.setUniversity(university);
        return mapToDTO(studyPlanRepository.save(studyPlanEntity));
    }

    public StudyPlanRes mapToDTO(StudyPlanEntity entity) {
        return new StudyPlanRes(
                entity.getName(),
                entity.getValidUntil(),
                entity.getUniversity().getId()
        );
    }
}
