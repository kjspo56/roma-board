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
    private String title;
    private String content;
    private String writer;
    private int view;

    @Builder
    public Post(Long seq, String title, String content, String writer, int view){
        this.seq = seq;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
    }

    public void modifyPost(String title, String content, String writer, int view){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view = view;
    }
}
