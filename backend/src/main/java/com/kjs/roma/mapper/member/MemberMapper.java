package com.kjs.roma.mapper.member;

import com.kjs.roma.dto.member.MemberDTO;
import com.kjs.roma.mapper.GenericMapper;
import com.kjs.roma.model.member.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends GenericMapper<MemberDTO, Member> {
}
