package com.example.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
    @GetMapping("/quiz")
    public String quizList(){
        return "/quiz/quiz";
    }

    @GetMapping("/quiz/insert")
    public String quizInsert(){
        return "/quiz/insert";
    }

    @PostMapping("/quiz/delete")
    public String quizDelete(){
        return "/quiz/delete";
    }
}
