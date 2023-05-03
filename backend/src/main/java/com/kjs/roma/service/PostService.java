package com.kjs.roma.service;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.environment.response.ApiResponse;
import com.kjs.roma.model.post.Post;
import com.kjs.roma.repository.post.PostRepository;
import com.kjs.roma.response.ResponseCode;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public ApiResponse list() throws ServiceException {
        List<Post> postList = postRepository.findAll();
        return ApiResponse.createSuccess(postList);
    }

    public ApiResponse get(long seq) throws ServiceException {
        Post post = postRepository.findById(seq).orElseThrow(EntityNotFoundException::new);
        return ApiResponse.createSuccess(post);
    }

    @Transactional
    public ApiResponse updateVisit(long seq) throws ServiceException {
        Post post = postRepository.findById(seq).orElseThrow((() ->
                new IllegalStateException("This post does not exist.")));

        int view = post.getView() + 1;
        PostDTO postDTO = PostDTO.builder()
                .view(view)
                .build();
        post.updateVisit(postDTO.view());
        return ApiResponse.createSuccess(ResponseCode.SUCCESS.code());
    }

    @Transactional
    public ApiResponse create(PostDTO postDTO) {
        Post post = Post.builder()
                .title(postDTO.title())
                .content(postDTO.content())
                .writer(postDTO.writer())
                .view(postDTO.view())
                .build();
        postRepository.save(post);
        return ApiResponse.createSuccess(postDTO);
    }

    @Transactional
    public ApiResponse update(PostDTO postDTO) {
        Post existingPost = postRepository.findById(postDTO.seq()).orElseThrow(EntityNotFoundException::new);
        existingPost.modifyPost(postDTO.title(), postDTO.content(), postDTO.writer());
        Post updatePost = postRepository.save(existingPost);
        return ApiResponse.createSuccess(updatePost);
    }

    @Transactional
    public ApiResponse delete(Long seq) {
        Optional<Post> optionalPost = postRepository.findById(seq);
        if (optionalPost.isPresent()) {
            postRepository.deleteById(seq);
            return ApiResponse.createSuccess(ResponseCode.SUCCESS.code());
        } else {
            throw new ServiceException(ResponseCode.NO_DATA_FOUND.code());
        }
    }

}
