package com.kjs.roma.dto.user;

import com.kjs.roma.model.user.Role;
import com.kjs.roma.model.user.User;
import lombok.Builder;

@Builder
public record UserDTO(Long seq, String username, String password, String nickname, String email, Role role) {

    public User toEntity(){
        User user = User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(role)
                .build();
        return user;
    }
}
