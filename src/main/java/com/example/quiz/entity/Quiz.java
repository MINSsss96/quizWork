package com.example.quiz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Quiz {
    @Id
    @Column(length = 50, nullable = false)
private String question;
private Long answerTrue;
private Long answerFalse;
}
