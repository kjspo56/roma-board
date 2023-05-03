package com.kjs.roma.dto.post;

import com.kjs.roma.model.post.Post;
import lombok.Builder;

@Builder
public record PostDTO(Long seq, String title, String content, String writer, int view) {

    public Post toEntity(){
        return Post.builder()
                .seq(seq)
                .title(title)
                .content(content)
                .writer(writer)
                .view(view)
                .build();
    }
}

