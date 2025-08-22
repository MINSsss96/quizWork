package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Play {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    private boolean userAnswer;

    private boolean correct;

}
