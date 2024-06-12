package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<UniversityEntity, Long> {
}
