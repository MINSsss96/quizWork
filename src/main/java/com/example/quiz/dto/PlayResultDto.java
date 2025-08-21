package com.example.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayResultDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserAnswer {
        private Long quizId;         // 어떤 퀴즈에 대한
        private String userAnswer;   // 유저의 입력 답안
    }


    private List<UserAnswer> answers;

    // 점수 계산 메서드
    public int calculateScore(List<QuizDto> correctQuizzes) {
        int score = 0;

        for (UserAnswer userAnswer : answers) {
            for (QuizDto quiz : correctQuizzes) {
                if (quiz.getId().equals(userAnswer.getQuizId())) {

                    // 유저 답안을 boolean으로 변환 (O → true, X → false)
                    boolean userAnswerBool = "O".equalsIgnoreCase(userAnswer.getUserAnswer().trim());

                    // 정답과 비교
                    if (quiz.isAnswerTrue() == userAnswerBool) {
                        score++;
                    }

                    break;
                }
            }
        }

        return score;
    }



}
