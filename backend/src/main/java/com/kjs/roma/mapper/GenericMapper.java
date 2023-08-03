package com.kjs.roma.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

public interface GenericMapper<D, E> {
    D toDto(E e);
    E toEntity(D d);

    List<D> toDTOList(List<E> entitiyList);
    List<E> toEntityList(List<D> dtoList);

    Set<D> toDTOSet(Set<E> entitiyList);
    Set<E> toEntitySet(Set<D> dtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(D dto, @MappingTarget E e);
}
