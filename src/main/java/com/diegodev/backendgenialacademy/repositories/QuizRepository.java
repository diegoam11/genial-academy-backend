package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    List<QuizEntity> findByTopicId(Long topicId);
}
