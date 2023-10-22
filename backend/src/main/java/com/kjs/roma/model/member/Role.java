package com.kjs.roma.model.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_MEMBER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자");

        private final String key;
        private final String value;
}
