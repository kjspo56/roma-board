package com.kjs.roma.dto.page;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
public class PageDTO {
    private String sortField = "regDate";
    private int page = 0;
    private int size = 10;
    private String sort ="DESC";
    private PageRequest pageRequest;
    private List<SearchOptionDTO> searchOption;

    public <T> T getValue(String key) {
        Optional<SearchOptionDTO> optionDTO = this.searchOption.stream()
                .filter(searchOption -> key.equals(searchOption.getKey())).findFirst();
        return optionDTO.map(searchOptionDTO -> (T) searchOptionDTO.getValue()).orElse(null);
    }

    public Sort.Direction getSort() {
        return "desc".equalsIgnoreCase(this.sort) ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(page, size, Sort.by(getSort(), sortField));
    }

    public OrderSpecifier<?> queryDslOrder(Path<Object> fieldPath){
        return new OrderSpecifier("desc".equalsIgnoreCase(this.sort) ? Order.DESC : Order.ASC, fieldPath);
    }
}
