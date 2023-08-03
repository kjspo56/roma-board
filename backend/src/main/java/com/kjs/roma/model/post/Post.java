package com.kjs.roma.model.post;

import com.kjs.roma.model.CommonField;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Post extends CommonField {

    @Id
    @Column(name = "seq", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @Column(nullable = false)
    private String writer;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;

//    private String childYn;

    @Builder
    public Post(Long seq, String title, String content, String writer, int view){
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
    }

//    public void updateChildYn(String childYn){
//        this.childYn = childYn;
//    }
}
