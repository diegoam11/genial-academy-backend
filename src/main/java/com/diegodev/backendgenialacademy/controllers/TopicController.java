package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.TopicRes;
import com.diegodev.backendgenialacademy.services.TopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/findByCourseId/{id}")
    public List<TopicRes> findByCourseId(@PathVariable Long id){
        return topicService.findByCourseId(id);
    }
}
