package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
