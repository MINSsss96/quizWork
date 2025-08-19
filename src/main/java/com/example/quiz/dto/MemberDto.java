package com.example.quiz.dto;

import com.example.quiz.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberDto {

    private Long no;
    @NotBlank(message = "아이디 입력하셔야 합니다.")
    private String id;
    @NotBlank(message = "비밀번호 입력하셔야 합니다.")
    private String password;
    private boolean status;
    private Long answerTrue;
    private Long answerFalse;



    // Entity -> Dto 변경
    public static MemberDto fromEntity(Member member) {
        return new MemberDto(
                member.getNo(),
                member.getId(),
                member.getPassword(),
                member.isStatus(),
                member.getAnswerTrue(),
                member.getAnswerFalse()
        );
    }

    public static Member toDto(MemberDto dto){
        Member member = new Member();
        member.setId(dto.getId());
        member.setId(dto.getId());
        member.setPassword(dto.getPassword());
        member.setAnswerTrue(dto.getAnswerTrue());
        member.setAnswerFalse(dto.getAnswerFalse());
        return member;
    }


}
