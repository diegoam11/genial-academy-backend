package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
    List<AreaEntity> findByUniversityId(Long universityId);
}
