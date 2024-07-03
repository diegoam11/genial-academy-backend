package com.diegodev.backendgenialacademy.dtos.requests;

public record QuizReq(
        String question,
        Long topicId,
        Long levelId
) {
}
