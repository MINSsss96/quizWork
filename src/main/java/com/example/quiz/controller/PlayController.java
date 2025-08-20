package com.example.quiz.controller;

import com.example.quiz.service.PlayService;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/play")
public class PlayController {
    @Autowired
    PlayService service;
}
