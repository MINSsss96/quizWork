package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(length = 50, nullable = false)
    private String  id;
    @Column(length = 50, nullable = false)
    private String password;
    private boolean status;
    private Long answerTrue;
    private Long answerFalse;

}
