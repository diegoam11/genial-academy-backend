package com.diegodev.backendgenialacademy.controllers;

import com.diegodev.backendgenialacademy.dtos.responses.QuizRes;
import com.diegodev.backendgenialacademy.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
@CrossOrigin
public class QuizController {
    private final QuizService quizService;

    public QuizController(final QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/findByTopicId/{id}")
    public List<QuizRes> findAll(@PathVariable Long id){
        return quizService.findByTopicId(id);
    }
}
