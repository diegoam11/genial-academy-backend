package com.diegodev.backendgenialacademy.repositories;

import com.diegodev.backendgenialacademy.entities.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizOptionRepository extends JpaRepository<OptionEntity, Long> {
    List<OptionEntity> findByQuizId(Long quizId);
}
