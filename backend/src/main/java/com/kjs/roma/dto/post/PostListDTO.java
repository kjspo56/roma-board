package com.kjs.roma.dto.post;

import java.sql.Timestamp;

public record PostListDTO(Long postId, String title, String writer, int view, int postLike, Timestamp regDate) {
}
