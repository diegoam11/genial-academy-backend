package com.diegodev.backendgenialacademy.dtos.responses;

public record QuizOptionRes(
        Long id,
        boolean isCorrect,
        String optionText,
        Long quizId
) {
}
