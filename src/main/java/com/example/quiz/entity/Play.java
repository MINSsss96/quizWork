package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;         // 어떤 퀴즈에 대한
    private String userAnswer;   // 유저의 입력 답안
}
