package com.example.quiz.dto;

import com.example.quiz.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class QuizDto {

    private Long id;
    @NotBlank(message = "퀴즈내용을 입력하셔야 합니다.")
    private String question;
    private boolean answerTrue;
    private String memberId;


    public static QuizDto fromQuizEntity(Quiz quiz) {
        return new QuizDto(
                quiz.getId(),
                quiz.getQuestion(),
                quiz.isAnswerTrue(),
                quiz.getMemberId()
        );
    }

    public static Quiz toDto(QuizDto dto){
        Quiz quiz = new Quiz();
        quiz.setQuestion(dto.getQuestion());
        quiz.setAnswerTrue(dto.isAnswerTrue());
        quiz.setMemberId(dto.getMemberId());
        return quiz;
    }
}
