package com.kjs.roma.repository.post;

import com.kjs.roma.dto.page.PageDTO;
import com.kjs.roma.dto.post.PostDTO;

import java.util.List;

public interface PostQueryDslRepository {
    List<PostDTO> findAllByDynamicQueryDsl(PageDTO pageDTO);
}
