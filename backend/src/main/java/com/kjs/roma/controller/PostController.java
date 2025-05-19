package com.kjs.roma.controller;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    /**
     * 게시물 등록
     * @param postDTO
     * @return
     */
    @PostMapping
    public JsonResponse create(@RequestBody PostDTO postDTO) {
        return postService.create(postDTO);
    }

    /**
     * 게시물 수정
     * @param postDTO
     * @return
     */
    @PutMapping
    public JsonResponse update(@RequestBody PostDTO postDTO) {
        return postService.update(postDTO);
    }

    /**
     * 게시물 목록
     * @param pageable
     * @return
     */
    @PostMapping("/list")
    public JsonResponse getList(Pageable pageable) {
        return postService.getList(pageable);
    }

    /**
     * 게시물 상세조회
     * @param postId
     * @return
     */
    @GetMapping("/{postId}")
    public JsonResponse get(@PathVariable("postId") Long postId, HttpSession session) {
        return postService.get(postId, session);
    }

    /**
     * 게시물 삭제
     * @param postId
     * @return
     */
    @DeleteMapping("/{postId}")
    public JsonResponse delete(@PathVariable("postId") Long postId){
        return postService.delete(postId);
    }
}
