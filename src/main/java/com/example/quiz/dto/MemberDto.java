package com.example.quiz.dto;

import com.example.quiz.entity.Member;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private boolean isAdmin;
    private int totalAnswered;
    private int correctAnswered;
    private double accuracy; // 정답률 (%)

    // Entity -> DTO 변환
    public static MemberDto fromMemberEntity(Member member) {
        return new MemberDto(
                member.getId(),
                member.getMemberId(),
                member.getPassword(),
                member.isAdmin(),
                member.getTotalAnswered(),
                member.getCorrectAnswered(),
                member.getAccuracy()
        );

    }

    // DTO -> Entity 변환
    public static Member toDto(MemberDto dto) {
        Member member = new Member();
        member.setId(dto.getId());
        member.setMemberId(dto.getMemberId());
        member.setPassword(dto.getPassword());
        member.setAdmin(dto.isAdmin());
        member.setTotalAnswered(dto.getTotalAnswered());
        member.setCorrectAnswered(dto.getCorrectAnswered());
        member.setAccuracy(dto.getAccuracy());
        return member;
    }
}
