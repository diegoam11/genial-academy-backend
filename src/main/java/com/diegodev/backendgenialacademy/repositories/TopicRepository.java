package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
    List<TopicEntity> findByCourseId(Long courseId);
}
