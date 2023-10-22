package com.kjs.roma.controller;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.service.post.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @PostMapping("/")
    public JsonResponse create(@RequestBody PostDTO postDTO) throws ServiceException {
        return postService.create(postDTO);
    }

    @PutMapping("/")
    public JsonResponse update(@RequestBody PostDTO postDTO) throws ServiceException {
        return postService.update(postDTO);
    }
}
