package com.kjs.roma.service;

import com.kjs.roma.dto.post.PostDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.mapper.post.PostMapper;
import com.kjs.roma.model.post.Post;
import com.kjs.roma.repository.post.PostRepository;
import com.kjs.roma.environment.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public JsonResponse create(PostDTO postDTO){
        //duplicate check
        boolean check = duplicateTitleCheck(postDTO.title());
        if(check){
            return JsonResponse.create(ResponseCode.CONFLICT_DATA.code());
            //menu.updateTitle(menu.getMenuTitle() + duplicateTitle(menu.getMenuTitle()));
        }else{
            Optional<Post> updateChild = postRepository.findById(postDTO.seq());
            if(updateChild.isPresent()){
//                updateChild.get().updateChildYn("Y");
                postRepository.save(updateChild.get());

                Post menu = postMapper.toEntity(postDTO);
                postRepository.save(menu);

                return JsonResponse.create(postMapper.toDto(menu));
            }else{
                return JsonResponse.create(ResponseCode.NO_DATA_FOUND.code());
            }
        }
    }

    public boolean duplicateTitleCheck(String title){
        return postRepository.existsByTitle(title);
    }

}
