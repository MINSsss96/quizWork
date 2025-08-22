package com.example.quiz.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping({"","/"})
    public String main(){
        return "main";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Member member = memberService.login(username, password); // 직접 만든 로그인 로직
        if (member != null) {
            session.setAttribute("loginMember", member);
            return "redirect:/menu";
        } else {
            return "redirect:/login?error";
        }
    }

}
