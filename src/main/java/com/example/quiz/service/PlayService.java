package com.example.quiz.service;

import com.example.quiz.repository.PlayRepository;
import com.example.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayService {

    private final PlayRepository repository;
    private final QuizRepository QuizRepository;

    public PlayService(PlayRepository repository, QuizRepository quizRepository) {
        this.repository = repository;
        this.QuizRepository = quizRepository;
    }

}
