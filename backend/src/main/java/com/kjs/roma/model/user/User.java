package com.kjs.roma.model.user;

import com.kjs.roma.model.CommonField;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "_user")
@ToString
public class User extends CommonField{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long seq, String username, String nickname, String email, Role role){
        this.seq = seq;
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
    }

    public User update(String username){
        this.username = username;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


}
