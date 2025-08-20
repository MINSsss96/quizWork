package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String memberId;
    @Column(length = 50, nullable = false)
    private String password;
    private boolean status;
    private boolean answerTrue;

}
