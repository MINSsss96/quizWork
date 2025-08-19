package com.example.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class QuizDto {

    private String question;
    private Long answerTrue;
    private Long answerFalse;

}
