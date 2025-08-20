package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String question;
    private boolean answerTrue;
}
