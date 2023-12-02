package com.kjs.roma.controller;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @PostMapping("/")
    public JsonResponse create(@RequestBody PostDTO postDTO) {
        return postService.create(postDTO);
    }

    @PutMapping("/")
    public JsonResponse update(@RequestBody PostDTO postDTO) {
        return postService.update(postDTO);
    }

    @PostMapping("/list")
    public JsonResponse getList(Pageable pageable) {
        return postService.getList(pageable);
    }

    @GetMapping("/{postId}")
    public JsonResponse get(@PathVariable("postId") Long postId) {
        return postService.get(postId);
    }

    @DeleteMapping("/{postId}")
    public JsonResponse delete(@PathVariable("postId") Long postId){
        return postService.delete(postId);
    }
}
