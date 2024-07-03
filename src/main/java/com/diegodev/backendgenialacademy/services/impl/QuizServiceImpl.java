package com.diegodev.backendgenialacademy.services.impl;

import com.diegodev.backendgenialacademy.dtos.responses.QuizOptionRes;
import com.diegodev.backendgenialacademy.dtos.responses.QuizRes;
import com.diegodev.backendgenialacademy.entities.OptionEntity;
import com.diegodev.backendgenialacademy.entities.QuizEntity;
import com.diegodev.backendgenialacademy.repositories.QuizOptionRepository;
import com.diegodev.backendgenialacademy.repositories.QuizRepository;
import com.diegodev.backendgenialacademy.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final QuizOptionRepository quizOptionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, QuizOptionRepository quizOptionRepository) {
        this.quizRepository = quizRepository;
        this.quizOptionRepository = quizOptionRepository;
    }

    @Override
    public List<QuizRes> findByTopicId(Long topicId) {
        List<QuizEntity> quizEntities = quizRepository.findByTopicId(topicId);
        List<QuizRes> quizResList = new ArrayList<>();
        for(QuizEntity quiz : quizEntities){
            QuizRes quizRes = new QuizRes();
            quizRes.setId(quiz.getId());
            quizRes.setQuestion(quiz.getQuestion());
            quizRes.setLevelId(quiz.getLevel().getId());
            quizRes.setTopicId(quiz.getTopic().getId());

            List<OptionEntity> optionsList = quizOptionRepository.findByQuizId(quiz.getId());
            List<QuizOptionRes> quizOptionResList = new ArrayList<>();
            for(OptionEntity option : optionsList){
                quizOptionResList.add(new QuizOptionRes(
                        option.getId(),
                        option.getIsCorrect(),
                        option.getOptionText(),
                        option.getQuiz().getId()
                ));
            }
            quizRes.setOptions(quizOptionResList);
            // add quizRes to List
            quizResList.add(quizRes);
        }
        return quizResList;
    }
}
