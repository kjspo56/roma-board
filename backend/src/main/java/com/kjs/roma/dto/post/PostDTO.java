package com.kjs.roma.dto.post;

import com.kjs.roma.model.post.Post;
import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record PostDTO(Long postId, String title, String content, String writer, int postLike, Timestamp regDate, int view) {

}

