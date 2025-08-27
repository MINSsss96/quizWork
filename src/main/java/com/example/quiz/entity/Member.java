package com.example.quiz.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data


public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String memberId;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isAdmin = false;

    // 유저가 푼 문제 개수
    private int totalAnswered = 0;

    // 유저가 맞춘 문제 개수
    private int correctAnswered = 0;

    private double accuracy =0;
}
