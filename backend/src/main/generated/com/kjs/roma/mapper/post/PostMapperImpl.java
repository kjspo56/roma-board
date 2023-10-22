package com.kjs.roma.mapper.post;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.model.post.Post;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T14:48:23+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDTO toDto(Post e) {
        if ( e == null ) {
            return null;
        }

        PostDTO.PostDTOBuilder postDTO = PostDTO.builder();

        postDTO.postId( e.getPostId() );
        postDTO.title( e.getTitle() );
        postDTO.content( e.getContent() );
        postDTO.writer( e.getWriter() );
        postDTO.view( e.getView() );

        return postDTO.build();
    }

    @Override
    public Post toEntity(PostDTO d) {
        if ( d == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.postId( d.postId() );
        post.title( d.title() );
        post.content( d.content() );
        post.writer( d.writer() );
        post.view( d.view() );

        return post.build();
    }

    @Override
    public List<PostDTO> toDTOList(List<Post> entitiyList) {
        if ( entitiyList == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( entitiyList.size() );
        for ( Post post : entitiyList ) {
            list.add( toDto( post ) );
        }

        return list;
    }

    @Override
    public List<Post> toEntityList(List<PostDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( dtoList.size() );
        for ( PostDTO postDTO : dtoList ) {
            list.add( toEntity( postDTO ) );
        }

        return list;
    }

    @Override
    public Set<PostDTO> toDTOSet(Set<Post> entitiyList) {
        if ( entitiyList == null ) {
            return null;
        }

        Set<PostDTO> set = new LinkedHashSet<PostDTO>( Math.max( (int) ( entitiyList.size() / .75f ) + 1, 16 ) );
        for ( Post post : entitiyList ) {
            set.add( toDto( post ) );
        }

        return set;
    }

    @Override
    public Set<Post> toEntitySet(Set<PostDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        Set<Post> set = new LinkedHashSet<Post>( Math.max( (int) ( dtoList.size() / .75f ) + 1, 16 ) );
        for ( PostDTO postDTO : dtoList ) {
            set.add( toEntity( postDTO ) );
        }

        return set;
    }

    @Override
    public void updateFromDto(PostDTO dto, Post e) {
        if ( dto == null ) {
            return;
        }
    }
}
