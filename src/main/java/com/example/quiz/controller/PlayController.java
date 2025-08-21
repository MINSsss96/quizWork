package com.example.quiz.controller;

import com.example.quiz.dto.PlayResultDto;
import com.example.quiz.dto.QuizDto;
import com.example.quiz.service.PlayService;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/play")
public class PlayController {
    @Autowired
    QuizService service;

    @GetMapping("")
    public String play(Model model){
        model.addAttribute("play", "플레이하기");
        //서비스에 멤버리스트 정보 요청
        List<QuizDto> quizList = service.getAllList();
        model.addAttribute("list", quizList);
        return "/play/play";
    }

    @PostMapping("/check")
    public String checkAnswer(@RequestParam Long quizId,
                              @RequestParam String userAnswer,
                              Model model) {

        QuizDto quiz = QuizService.findQuiz(quizId);  // 기존 메서드 재사용
        boolean userAnswerBool = "O".equalsIgnoreCase(userAnswer.trim());
        boolean correct = (quiz.isAnswerTrue() == userAnswerBool);

        model.addAttribute("correct", correct);
        model.addAttribute("quiz", quiz);

        return "/play/feedback"; // 정답 확인 후 다음 문제로 이동 유도
    }

    @PostMapping("/submit")
    public String submitAnswers(@ModelAttribute PlayResultDto resultDto, Model model) {
        List<QuizDto> correctAnswers = service.getAllList();  // 실제 정답 리스트
        int score = resultDto.calculateScore(correctAnswers);     // 점수 계산
        model.addAttribute("score", score);
        model.addAttribute("total", correctAnswers.size());
        return "/play/result";  // 결과 페이지
    }
}
