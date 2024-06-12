package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.CourseDTO;
import com.diegodev.backendgenialacademy.entities.CourseEntity;
import com.diegodev.backendgenialacademy.entities.StudyPlanEntity;
import com.diegodev.backendgenialacademy.repositories.CourseRepository;
import com.diegodev.backendgenialacademy.repositories.StudyPlanRepository;
import com.diegodev.backendgenialacademy.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudyPlanRepository studyPlanRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudyPlanRepository studyPlanRepository) {
        this.courseRepository = courseRepository;
        this.studyPlanRepository = studyPlanRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO create(CourseDTO course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(course.name());
        courseEntity.setDescription(course.description());
        StudyPlanEntity studyPlanEntity = studyPlanRepository.findById(course.studyPlanId()).orElse(null);
        courseEntity.setStudyPlan(studyPlanEntity);
        return mapToDTO(courseRepository.save(courseEntity));
    }

    public CourseDTO mapToDTO(CourseEntity entity) {
        return new CourseDTO(
                entity.getName(),
                entity.getDescription(),
                entity.getStudyPlan().getStudyPlanId()
        );
    }
}
