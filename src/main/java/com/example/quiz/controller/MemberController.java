package com.example.quiz.controller;

import com.example.quiz.dto.MemberDto;
import com.example.quiz.entity.Member;
import com.example.quiz.repository.MemberRepository;
import com.example.quiz.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class MemberController {

    //서비스를 가져와서 실행할 준비
    // 1. @Autowired 사용
    @Autowired
    MemberService service;
    // 2.

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("login")
    public String loginForm() {
        return "/login";
    }

    @GetMapping("signup")
    public String signupForm(Model model) {
        model.addAttribute("member", new MemberDto());
        return "/signup";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute("member") MemberDto dto) {
        memberService.saveMember(dto);
        return "redirect:/";
    }

    @PostMapping("login")
    public String login(MemberDto dto, HttpSession session) {
        // 1. dto.email을 갖고 user 검색

        MemberDto loginResult = memberService.findOneUser(dto.getId());
        // 2. 해당 유저가 있는지 확인한다.
        if (ObjectUtils.isEmpty(loginResult)) {
            // 로그인 실패
            return "/member/login";
        } else if (dto.getPassword().equals(loginResult.getPassword())) {
            // 3. password 가 맞는지 확인한다
            // 맞으면 : 세션을 만들어 준다.
            session.setAttribute("loginMemberId", dto.getMemberId());
            // 세션 유지 시간
            session.setMaxInactiveInterval(60 * 30);
            return "redirect:/";
        } else {
            // 틀리면 : login form 보여준다.
            return "/member/login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        // 세션을 삭제하는 메서드
        session.invalidate();
        return "main";
    }



//    @PostMapping("/register")
//    public String register(@ModelAttribute MemberDto memberDto) {
//        Member member = MemberDto.toEntity(memberDto);
//        memberRepository.save(member);  // DB 저장
//        return "redirect:/login"; // 회원가입 후 로그인 페이지로 이동
//    }

//    @GetMapping("/list")
//    public String showList(Model model) {
//        model.addAttribute("title", "리스트보기");
//        //서비스에 멤버리스트 정보 요청
//        List<MemberDto> memberList = service.getAllList();
//        model.addAttribute("list", memberList);
//        return "/showMember";
//    }

//    @GetMapping("/register")
//    public String insertFormView(Model model) {
//        // insertForm 에 껍데기 Dto를 보냄
//        model.addAttribute("dto",new MemberDto());
//        return "/register";
//    }
//
//    @PostMapping("/register")
//    public String insert(@Valid @ModelAttribute("dto") MemberDto dto,
//                         BindingResult bindingResult) {
//        // 0. DTO에서 설정한 Validation에 오류가 있는지 검사
//        // 만약 오류가 있다면 insertForm을 다시 보여 준 후 종료
//        if(bindingResult.hasErrors()) {
//            return "register";
//        }
//
//
//        // 1. 폼에서 보낸 정보를 DTO로 받는다.
//        System.out.println(dto);
//        // 2. 받은 DTO를 서비스로 보낸다.
//        service.insertMember(dto);
//
//        // 3. 서비스에서 DTO를 entity로 바꾼다.
//        // 4. repository를 이용해서 저장한다.
//        // 5. 메인 리스트화면으로 돌아간다.
//        return "redirect:/list";
//    }

    @PostMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable("id") Long id) {
        service.deleteMember(id);

        return "redirect:/list";
    }

//    @GetMapping("/member/updateView")
//    public String updateView(@RequestParam("updateId") Long updateId, Model model) {
//        // 1. 받은 수정 아이디로 데이터를 검색해온다.(DTO)
//        MemberDto dto = service.findMember(updateId);
//        // 2. DTO가 비어있는지 확인한다. ID의 유무를 확인 -> 조치를 취함
//        if (ObjectUtils.isEmpty(dto)) {
//            return "redirect:/list";
//        } else {
//            // 3. 받은 DTO를 수정폼으로 보낸다.
//            model.addAttribute("dto", dto);
//            return "updateForm";
//        }
//    }

//    @PostMapping("/member/update")
//    public String update(@Valid @ModelAttribute("dto") MemberDto dto,
//                         BindingResult bindingResult) {
//
//        if(bindingResult.hasErrors()) {
//            return "updateForm";
//        }
//
////        System.out.println(dto);
//        service.updateMember(dto);
//
//        return "redirect:/list";
//    }
//
//    @GetMapping("/member/search")
//    public String search(@RequestParam("type") String type,
//                         @RequestParam("keyword") String keyword,
//                         Model model) {
//        List<MemberDto> searchList = service.searchMember(type, keyword);
//        if (ObjectUtils.isEmpty(searchList)) {
//            // 검색결과가 없을경우
//            searchList = null;
//            model.addAttribute("list", searchList);
//        } else {
//            // 검색결과가 있을 경우
//            model.addAttribute("list", searchList);
//        }
//        return "showMember";
//        //select * from member where address like "%서울%";
//
//    }





//    @WebFilter("/*")
//    public class LoginCheckFilter implements Filter {
//        @Override
//        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//                throws IOException, ServletException {
//            HttpServletRequest req = (HttpServletRequest) request;
//            HttpServletResponse res = (HttpServletResponse) response;
//
//            String uri = req.getRequestURI();
//            if (uri.startsWith("/css") || uri.equals("/login") || uri.equals("/register")) {
//                chain.doFilter(request, response);
//                return;
//            }
//
//            HttpSession session = req.getSession(false);
//            boolean isLoggedIn = session != null && session.getAttribute("loginMember") != null;
//
//            if (!isLoggedIn) {
//                res.sendRedirect("/login");
//                return;
//            }
//
//            chain.doFilter(request, response);
//        }
//    }

}
