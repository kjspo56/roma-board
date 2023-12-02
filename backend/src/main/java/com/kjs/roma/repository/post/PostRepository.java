package com.kjs.roma.repository.post;

import com.kjs.roma.model.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post>, PostQueryDslRepository, QuerydslPredicateExecutor<Post> {


    boolean existsByTitle(String title);

    int countByPostId(Long parentId);

}
