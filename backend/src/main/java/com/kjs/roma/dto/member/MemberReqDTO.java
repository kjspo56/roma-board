package com.kjs.roma.dto.member;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record MemberReqDTO(Long memberId, String username, String email, String password, String token,
                           String refreshToken, String role, String userStatus, String department, Timestamp lastAccessTime, Timestamp lastChangeTime) {
}
