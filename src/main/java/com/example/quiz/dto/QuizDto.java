package com.example.quiz.dto;

import com.example.quiz.entity.Member;
import com.example.quiz.entity.Quiz;
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

    public static QuizDto fromEntity(Quiz quiz) {
        return new QuizDto(
                quiz.getQuestion(),
                quiz.getAnswerTrue(),
                quiz.getAnswerFalse()
        );
    }

    public static Member toDto(MemberDto dto){
        Member member = new Member();
        member.setId(dto.getId());
        member.setId(dto.getId());
        member.setPassword(dto.getPassword());
        member.setAnswerTrue(dto.getAnswerTrue());
        member.setAnswerFalse(dto.getAnswerFalse());
        return member;
    }
}
