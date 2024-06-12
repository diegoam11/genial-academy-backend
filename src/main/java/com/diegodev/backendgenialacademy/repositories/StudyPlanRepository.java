package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.StudyPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanRepository extends JpaRepository<StudyPlanEntity, Long> {
}
