package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.StudyPlanRes;
import com.diegodev.backendgenialacademy.services.StudyPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study_plan")
@CrossOrigin
public class StudyPlanController {

    private final StudyPlanService studyPlanService;

    public StudyPlanController(StudyPlanService studyPlanService) {
        this.studyPlanService = studyPlanService;
    }

    @PostMapping("/create")
    public StudyPlanRes createStudyPlan(@RequestBody StudyPlanRes studyPlanRes) {
        return studyPlanService.createStudyPlan(studyPlanRes);
    }
}
