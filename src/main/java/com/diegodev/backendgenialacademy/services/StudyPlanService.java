package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.StudyPlanDTO;
import com.diegodev.backendgenialacademy.entities.StudyPlanEntity;

public interface StudyPlanService {
    StudyPlanDTO createStudyPlan(StudyPlanDTO studyPlanDTO);
}
