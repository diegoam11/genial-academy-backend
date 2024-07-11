package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.TopicRes;
import com.diegodev.backendgenialacademy.services.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
@CrossOrigin
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
