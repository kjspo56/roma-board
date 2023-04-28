package com.kjs.roma.service;

import com.kjs.roma.dto.PostDTO;
import com.kjs.roma.model.post.Post;
import com.kjs.roma.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> list() {
        List<Post> postList = postRepository.findAll();
        return postList.stream()
                .map(post -> new PostDTO(post.getSeq(), post.getTitle(), post.getContent(), post.getWriter(), post.getView()))
                .toList();
    }

    public PostDTO get(Long seq) {
        Post post = postRepository.findById(seq)
                .orElseThrow(EntityNotFoundException::new);
        return new PostDTO(post.getSeq(), post.getTitle(), post.getContent(), post.getWriter(), post.getView());
    }

    public PostDTO create(PostDTO postDTO) {
        Post post = Post.builder()
                .title(postDTO.title())
                .content(postDTO.content())
                .writer(postDTO.writer())
                .view(postDTO.view())
                .build();
        postRepository.save(post);
        return new PostDTO(post.getSeq(), post.getTitle(), post.getContent(), post.getWriter(), post.getView());
    }

    public PostDTO update(PostDTO postDTO) {
        Post existingPost = postRepository.findById(postDTO.seq())
                .orElseThrow(EntityNotFoundException::new);
        existingPost.modifyPost(postDTO.title(), postDTO.content(), postDTO.writer(), postDTO.view());
        Post updatedPost = postRepository.save(existingPost);
        return new PostDTO(updatedPost.getSeq(), updatedPost.getTitle(), updatedPost.getContent(), updatedPost.getWriter(), updatedPost.getView());
    }

    public void delete(Long seq) {
        postRepository.deleteById(seq);
    }

}
