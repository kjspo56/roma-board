package com.kjs.roma.service.post;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.dto.post.PostListDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.mapper.post.PostMapper;
import com.kjs.roma.model.post.Post;
import com.kjs.roma.repository.post.PostRepository;
import com.kjs.roma.environment.response.ResponseCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public JsonResponse create(PostDTO postDTO){
            Post post = postMapper.toEntity(postDTO);
            return JsonResponse.create(postMapper.toDto(postRepository.save(post)));
        }

    @Transactional
    public JsonResponse update(PostDTO postDTO) {
        boolean check = duplicateTitleCheck(postDTO.title());
        Post post = postRepository.findById(postDTO.postId()).orElseThrow(()-> new SecurityException(ResponseCode.NO_DATA_FOUND.code()));
        Long parentId = post.getPostId();
        if(check && !Objects.equals(post.getTitle(), postDTO.title())){
            return JsonResponse.create(ResponseCode.CONFLICT_DATA.code());
        }else{
            //update 메소드 추가
            postRepository.save(post);
            return JsonResponse.create(ResponseCode.SUCCESS.code());
        }
    }

    public JsonResponse list(PostListDTO postListDTO){
//        List<Post> posts = postRepository.findMenuByParentSeqAndUseYn(postListDTO.parentSeq(),"Y");
        List<Post> posts =postRepository.findAll();
        if(posts.isEmpty()){
            return JsonResponse.create(ResponseCode.NO_DATA_FOUND.code());
        }
        return JsonResponse.create(posts.stream().map(postMapper::toDto).collect(Collectors.toList()));
    }

    public JsonResponse get(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ServiceException(ResponseCode.NO_DATA_FOUND.code()));
        return JsonResponse.create(postMapper.toDto(post));
    }

    @Transactional
    public JsonResponse delete(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ServiceException(ResponseCode.NO_DATA_FOUND.code()));
//        int cnt = postRepository.countByParentSeq(seq);
        int cnt = 0;
        if(cnt == 0){
            //groupService.deleteMappingMenus(seq);
            postRepository.deleteById(postId);

            childCheck(post.getPostId());
        }else{
            return JsonResponse.create(ResponseCode.OTHERS.code(), "하위 메뉴 존재");
        }
        return JsonResponse.create(ResponseCode.SUCCESS.code());
    }

    public void childCheck(Long parentId){
        int parentSeqCnt = postRepository.countByPostId(parentId);
        //int parentSeqCnt = 0;
        Post parent = postRepository.findById(parentId).orElseThrow(() -> new ServiceException(ResponseCode.NO_DATA_FOUND.code()));
        if(parentSeqCnt == 0){
//            parent.updateChildYn("N");
        }else{
//            parent.updateChildYn("Y");
        }
        postRepository.save(parent);
    }


    public boolean duplicateTitleCheck(String title){
        return postRepository.existsByTitle(title);
    }

}
