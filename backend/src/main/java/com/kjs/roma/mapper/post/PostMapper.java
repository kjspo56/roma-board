package com.kjs.roma.mapper.post;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.dto.post.PostListDTO;
import com.kjs.roma.mapper.GenericMapper;
import com.kjs.roma.model.post.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper extends GenericMapper<PostDTO, Post> {

    PostListDTO postToPostListDTO(Post post);
}
