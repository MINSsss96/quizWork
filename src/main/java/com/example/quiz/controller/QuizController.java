package com.example.quiz.controller;

import com.example.quiz.dto.MemberDto;
import com.example.quiz.dto.QuizDto;
import com.example.quiz.entity.Quiz;
import com.example.quiz.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService service;

    @GetMapping("")
    public String quizList(Model model){
        model.addAttribute("title", "리스트보기");
        //서비스에 멤버리스트 정보 요청
        List<QuizDto> quizList = service.getAllList();
        model.addAttribute("list", quizList);
        return "/quiz/quiz";
    }

    @GetMapping("/insertForm")
    public String insertFormView(Model model){
        model.addAttribute("quiz",new QuizDto());
        return "/quiz/insert";
    }

    @PostMapping("/insert")
    public String insert(@Valid @ModelAttribute("quiz") QuizDto dto,
                         BindingResult bindingResult) {
        // 0. DTO에서 설정한 Validation에 오류가 있는지 검사
        // 만약 오류가 있다면 insertForm을 다시 보여 준 후 종료
        if(bindingResult.hasErrors()) {
            return "/quiz/insert";
        }


        // 1. 폼에서 보낸 정보를 DTO로 받는다.
        System.out.println(dto);
        // 2. 받은 DTO를 서비스로 보낸다.
        service.insertQuiz(dto);

        // 3. 서비스에서 DTO를 entity로 바꾼다.
        // 4. repository를 이용해서 저장한다.
        // 5. 메인 리스트화면으로 돌아간다.
        return "redirect:/quiz";
    }

    @PostMapping("/delete/{id}")
    public String quizDelete(@PathVariable("id")Long id){
        service.deleteQuiz(id);
        return "redirect:/quiz";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("dto") QuizDto dto,
                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "update";
        }

//        System.out.println(dto);
        service.updateQuiz(dto);

        return "redirect:/quiz";
    }


}
