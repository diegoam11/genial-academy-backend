package com.diegodev.backendgenialacademy.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizRes {
    private Long id;
    private String question;
    private Long levelId;
    private Long topicId;
    private List<QuizOptionRes> options;
}
