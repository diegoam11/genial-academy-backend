package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.StudyPlanDTO;
import com.diegodev.backendgenialacademy.services.StudyPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study_plan")
public class StudyPlanController {

    private final StudyPlanService studyPlanService;

    public StudyPlanController(StudyPlanService studyPlanService) {
        this.studyPlanService = studyPlanService;
    }

    @PostMapping("/create")
    public StudyPlanDTO createStudyPlan(@RequestBody StudyPlanDTO studyPlanDTO) {
        return studyPlanService.createStudyPlan(studyPlanDTO);
    }
}
