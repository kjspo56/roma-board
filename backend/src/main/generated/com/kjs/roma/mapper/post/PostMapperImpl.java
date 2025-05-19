package com.kjs.roma.mapper.post;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.dto.post.PostListDTO;
import com.kjs.roma.model.post.Post;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-19T14:37:01+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
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
        postDTO.postLike( e.getPostLike() );
        postDTO.regDate( e.getRegDate() );
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
        post.postLike( d.postLike() );

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

        if ( dto.regDate() != null ) {
            e.setRegDate( dto.regDate() );
        }
    }

    @Override
    public PostListDTO postToPostListDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        Long postId = null;
        String title = null;
        String writer = null;
        int view = 0;
        int postLike = 0;
        Timestamp regDate = null;

        postId = post.getPostId();
        title = post.getTitle();
        writer = post.getWriter();
        view = post.getView();
        postLike = post.getPostLike();
        regDate = post.getRegDate();

        PostListDTO postListDTO = new PostListDTO( postId, title, writer, view, postLike, regDate );

        return postListDTO;
    }
}
