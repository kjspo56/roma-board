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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    /**
     * DTO -> Entity
     * Entity 빌더를 통해 CRUD 생성하는 DTO에 dto -> entity 변환 메소드 추가하여 사용
     * @param postDTO
     * @return
     */
    public JsonResponse create(PostDTO postDTO) throws ServiceException {
        log.debug("create: {}", postDTO);
        try {
            if (duplicateTitleCheck(postDTO.title())) {
                return JsonResponse.create(ResponseCode.CONFLICT_DATA, "title is already in use");
            }
            if(validateTitle(postDTO.title()) != null){
                Post post = postMapper.toEntity(postDTO);
                //Todo : 파일 업로드 처리
                postRepository.save(post);
                return JsonResponse.create(postMapper.toDto(post));
            } else {
                return JsonResponse.create(ResponseCode.INVALID_PARAMETER);
            }
        } catch (IllegalArgumentException e) {
            return JsonResponse.create(ResponseCode.INVALID_PARAMETER, e.getMessage());
        }
    }

    /**
     * 해당 메소드는 에러 처리를 위한 샘플코드.
     * 1. 정의된 코드를 리턴하여 message 처리하는 방식
     * 2. 정의된 코드를 리턴하나 메세지를 서비스에서 직접 지정하는 방식.
     * - 일반적인 서비스에서 처리는 1번의 방식을 권장함(다국어 처리)
     * {
     * "resultCode": "999",
     * "resultMsg": "이건 서비스에서 정의한 메시지지", resultMsg 직접 처리.
     * "data": "",
     * "currentTimestamp": "2023-02-09T04:46:32.037+00:00"
     * }
     *
     * @param postDTO
     * @return
     */
    @Transactional
    public JsonResponse update(PostDTO postDTO) throws ServiceException {
        log.debug("postDTO : {}", postDTO);
        Post post = postRepository.findById(postDTO.postId()).orElseThrow(()-> new ServiceException(ResponseCode.NO_DATA_FOUND.code()));

        if(!post.getTitle().equals(postDTO.title()) && duplicateTitleCheck(postDTO.title())){
            return JsonResponse.create(ResponseCode.CONFLICT_DATA, "title is already use");
        }

        if(validateTitle(postDTO.title()) != null){
            //Todo : file 처리
            post.updatePost(postDTO.title(), postDTO.content());
            log.debug("update post Entity : {}", post);
            postRepository.save(post);
            return JsonResponse.create(postMapper.toDto(post));
        } else {
            return JsonResponse.create(ResponseCode.INVALID_PARAMETER);
        }
        /**
         * @Setter 메소드를 제외한 경우의 Entity 수정
         * 도메인에 업데이트할 항목을 정의하여 무분별한 set 메소드를 사용하지 않고 구현
         * - setter 메소드가 있을경우 set을 통한 엔티티 변경 후 변경감지로 트랙잭션이 종료되면 update 문 실행됨.
         * - 드문 케이스이긴 하겠지만 Service 외 다른 케이스에서 Entity 생성하여 setter 사용이 가능하면 운영시 update 가 어느 시점에서 발생했는지 디버그가 힘들어진 케이스 발생
         */
    }


    /**
     * paging sample, requestBody{page,size,searchOption} 을 가지고 Criteria 를 통한 dynamic 검색/Paging
     * Page: 일반적인 게시판 형태의 페이징에서 사용(count 쿼리를 포함하는 페이징 카운트 쿼리)
     * Slice: 더보기 형태의 페이징에서 사용(totalPages, totalElements 항목이 없음)
     *
     * @param
     * @return
     */
    public JsonResponse getList(Pageable pageable){
//        List<Post> postEntityList = postRepository.findAll();
        Page<Post> postEntityList = postRepository.findAll(pageable);
        if(postEntityList.isEmpty()){
            return JsonResponse.create(ResponseCode.NO_DATA_FOUND.code());
        }
        List<PostListDTO> postList = postEntityList.stream()
                .map(postMapper::postToPostListDTO).collect(Collectors.toList());
        return JsonResponse.create(postList, pageable, 0);
    }


    public JsonResponse get(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ServiceException(ResponseCode.NO_DATA_FOUND.code()));
        return JsonResponse.create(postMapper.toDto(post));
    }

    @Transactional
    public JsonResponse delete(Long postId) throws ServiceException {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            postRepository.deleteById(postId);
        } else {
            JsonResponse.create(ResponseCode.NO_DATA_FOUND);
        }
        return JsonResponse.create(ResponseCode.SUCCESS.code());
    }



    public boolean duplicateTitleCheck(String title){
        return postRepository.existsByTitle(title);
    }

    public String validateTitle(String title) {
        String pattern = "^(?=.*[가-힣a-zA-Z])(?!.*[ㄱ-ㅎㅏ-ㅣ]{2})[가-힣a-zA-Z0-9_]*$";
        if(!Pattern.matches(pattern, title)) {
            throw new IllegalArgumentException("Invalid title format");
        }
        return title.replaceAll("\\s", "");
    }
}
