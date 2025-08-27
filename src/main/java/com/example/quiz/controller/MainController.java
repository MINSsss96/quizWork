package com.example.quiz.controller;

import com.example.quiz.dto.MemberDto;
import com.example.quiz.entity.Member;
import com.example.quiz.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping({"","/"})
    public String main(){
        return "main";
    }
//    @Autowired
//    MemberService service;

//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "/member/login"; // login.html 보여줌
//    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
//        Member member = service.login(username, password); // 직접 만든 로그인 로직
//        if (member != null) {
//            session.setAttribute("loginMember", member);
//            return "redirect:/";
//        } else {
//            return "redirect:/login?error";
//        }
//    }
//
//    @GetMapping("/register")
//    public String showRegisterForm() {
//        return "register"; // register.html 따로 만들 수도 있고
//    }
//
//    @PostMapping("/register")
//    public String register(@RequestParam String username, @RequestParam String password) {
//        service.register(username, password); // 신규 회원 저장
//        return "redirect:/";
//    }





}
