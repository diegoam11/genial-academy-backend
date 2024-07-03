package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.QuizRes;

import java.util.List;

public interface QuizService {
    List<QuizRes> findByTopicId(Long topicId);
}
