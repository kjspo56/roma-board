package com.kjs.roma.controller;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
