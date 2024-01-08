package com.kjs.roma.model.member;

import com.kjs.roma.model.CommonField;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@DynamicUpdate
@DynamicInsert
public class Member extends CommonField{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    private String password;
    private String token;
    private String refreshToken;
    @Column
    private String nickname;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name ="user_status", columnDefinition = "CHAR(2) DEFAULT '00'")
    private String userStatus; // 00: 승인대기/준회원, 01 : 승인완료/정회원, 02: 사용안함
    private Timestamp lastAccessTime; //최종접속시간
    private String department;

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
