package com.kjs.roma.dto.member;

import com.kjs.roma.model.member.Role;
import com.kjs.roma.model.member.Member;
import lombok.Builder;

@Builder
public record MemberDTO(Long memberId, String username, String password, String nickname, String email, Role role) {

    public Member toEntity(){
        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(role)
                .build();
        return member;
    }
}
