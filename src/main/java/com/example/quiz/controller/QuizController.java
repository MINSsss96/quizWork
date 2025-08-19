package com.example.quiz.controller;

import com.example.quiz.dto.MemberDto;
import com.example.quiz.dto.QuizDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class QuizController {
    @GetMapping("/quiz")
    public String quizList(Model model){
        model.addAttribute("title", "리스트보기");
        //서비스에 멤버리스트 정보 요청
        List<QuizDto> quizDtoList = service.getAllList();
        model.addAttribute("list", memberList);
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
