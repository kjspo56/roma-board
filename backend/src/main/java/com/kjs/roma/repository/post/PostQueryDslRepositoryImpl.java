package com.kjs.roma.repository.post;

import com.kjs.roma.dto.page.PageDTO;
import com.kjs.roma.dto.post.PostDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kjs.roma.model.post.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostQueryDslRepositoryImpl implements PostQueryDslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PostDTO> findAllByDynamicQueryDsl(PageDTO pageDTO) {
        String title = pageDTO.getValue("title");
        Integer seq = pageDTO.getValue("seq");
        return jpaQueryFactory.select(
                        Projections.constructor(PostDTO.class, post.seq, post.title, post.content)
                )
                .from(post)
                .where(titleEq(title), seqEq(seq))
                .fetch();
    }

    private BooleanExpression seqEq(Integer seq) {
        return seq == null ? null : post.seq.eq(Long.valueOf(seq));
    }

    private BooleanExpression titleEq(String title) {
        return (null == title || title.isBlank()) ? null : post.title.eq(title);
    }

}
