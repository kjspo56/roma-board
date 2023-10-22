package com.kjs.roma.dto.post;

import com.kjs.roma.model.post.Post;
import lombok.Builder;

@Builder
public record PostDTO(Long postId, String title, String content, String writer, int view) {

    public Post toEntity(){
        return Post.builder()
                .postId(postId)
                .title(title)
                .content(content)
                .writer(writer)
                .view(view)
                .build();
    }
}

