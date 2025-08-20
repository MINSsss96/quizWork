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

    private Long id;
    @NotBlank(message = "아이디 입력하셔야 합니다.")
    private String memberId;
    @NotBlank(message = "비밀번호 입력하셔야 합니다.")
    private String password;
    private boolean status;
    private boolean answerTrue;




    // Entity -> Dto 변경
    public static MemberDto fromEntity(Member member) {
        return new MemberDto(
                member.getId(),
                member.getMemberId(),
                member.getPassword(),
                member.isStatus(),
                member.isAnswerTrue()

        );
    }

    public static Member toDto(MemberDto dto){
        Member member = new Member();
        member.setId(dto.getId());
        member.setMemberId(dto.getMemberId());
        member.setPassword(dto.getPassword());
        member.setAnswerTrue(dto.isAnswerTrue());
        return member;
    }


}
