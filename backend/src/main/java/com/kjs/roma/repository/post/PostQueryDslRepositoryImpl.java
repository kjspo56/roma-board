package com.kjs.roma.repository.post;

import com.kjs.roma.dto.page.PageDTO;
import com.kjs.roma.dto.page.SearchOptionDTO;
import com.kjs.roma.dto.post.PostDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static com.kjs.roma.model.post.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostQueryDslRepositoryImpl implements PostQueryDslRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PostDTO> findAllByDynamicQueryDsl(PageDTO pageDTO) throws ServiceException {
        PageRequest pageRequest = PageRequest.of(pageDTO.getPage(), pageDTO.getSize(), Sort.by(pageDTO.getSort(), pageDTO.getSortField()));
        Path<Object> fieldPath = Expressions.path(Object.class, post, pageDTO.getSortField());  //orderBy 적용할때 필요한 filed값. Object, 경로, 변수
        BooleanBuilder builder = new BooleanBuilder();

        String title = pageDTO.getValue("title");
        Integer seq = pageDTO.getValue("seq");

        if(pageDTO.getSearchOption().size() > 0){ //size = 0 -> list All , size > 0 -> search
            for(SearchOptionDTO searchOption : pageDTO.getSearchOption()){
                String key = searchOption.getKey();
                String value = (String) searchOption.getValue();
                if(Objects.nonNull(searchOption.getValue()) && value.trim() != ""){   //null 처리
                    if ("title".equals(key)) {
                        builder.and(post.title.contains(value));
                    } else if ("content".equals(key)) {
                        builder.and(post.content.contains(value));
                    } else if ("writer".equals(key)) {
                        builder.and(post.writer.contains(value));
                    }
                }
            }
        }

        return jpaQueryFactory.select(
                        Projections.constructor(PostDTO.class, post.seq, post.title, post.content, post.writer, post.view)
                )
                .from(post)
                .where(builder.or(titleEq(title)), seqEq(seq))
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .orderBy(pageDTO.queryDslOrder(fieldPath))
                .fetch();
    }

    private BooleanExpression seqEq(Integer seq) {
        return seq == null ? null : post.seq.eq(Long.valueOf(seq));
    }

    private BooleanExpression titleEq(String title) {
        return (null == title || title.isBlank()) ? null : post.title.eq(title);
    }

}
