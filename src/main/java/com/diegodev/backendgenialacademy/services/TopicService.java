package com.diegodev.backendgenialacademy.services;

import com.diegodev.backendgenialacademy.dtos.responses.TopicRes;

import java.util.List;

public interface TopicService {
    List<TopicRes> findByCourseId(Long courseId);
}
