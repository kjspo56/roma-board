package com.kjs.roma.repository.post;

import com.kjs.roma.model.post.Post;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.awt.print.Pageable;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post>, PostQueryDslRepository, QuerydslPredicateExecutor<Post> {

    Slice<Post> findSliceBy(Pageable pageable);

    @Query("""
            select p from Post p where p.seq = :seq
            """)
    Post findSampleBy(Long seq);

}
