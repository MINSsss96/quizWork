package com.example.quiz.controller;

import com.example.quiz.dto.QuizDto;
import com.example.quiz.service.PlayService;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class PlayController {
    @Autowired
    PlayService service;

    @GetMapping("/play")
    public String play(Model model){
        model.addAttribute("play", "플레이하기");
        //서비스에 멤버리스트 정보 요청
//        List<QuizDto> quizList = service.getAllList();
//        model.addAttribute("list", quizList);
        return "/quiz/play";
    }

}
