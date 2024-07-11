package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.responses.TopicRes;
import com.diegodev.backendgenialacademy.entities.TopicEntity;
import com.diegodev.backendgenialacademy.repositories.TopicRepository;
import com.diegodev.backendgenialacademy.services.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<TopicRes> findByCourseId(Long courseId) {
        return topicRepository.findByCourseId(courseId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TopicRes mapToDTO(TopicEntity entity) {
        return new TopicRes(
                entity.getId(),
                entity.getName(),
                entity.getCourse().getId()
        );
    }
}
