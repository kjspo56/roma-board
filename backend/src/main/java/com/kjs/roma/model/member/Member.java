package com.kjs.roma.model.member;

import com.kjs.roma.model.CommonField;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "user_members")
@ToString
public class Member extends CommonField{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(length = 100)
    private String password;

    @Column
    private String nickname;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(Long memberId, String username, String password, String nickname, String email, Role role){
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
    }

    public Member update(String username){
        this.username = username;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


}
