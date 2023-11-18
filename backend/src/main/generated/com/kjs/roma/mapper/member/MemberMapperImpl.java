package com.kjs.roma.mapper.member;

import com.kjs.roma.dto.member.MemberDTO;
import com.kjs.roma.model.member.Member;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T22:43:47+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO toDto(Member e) {
        if ( e == null ) {
            return null;
        }

        MemberDTO.MemberDTOBuilder memberDTO = MemberDTO.builder();

        memberDTO.memberId( e.getMemberId() );
        memberDTO.username( e.getUsername() );
        memberDTO.password( e.getPassword() );
        memberDTO.nickname( e.getNickname() );
        memberDTO.email( e.getEmail() );
        memberDTO.role( e.getRole() );

        return memberDTO.build();
    }

    @Override
    public Member toEntity(MemberDTO d) {
        if ( d == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.memberId( d.memberId() );
        member.username( d.username() );
        member.password( d.password() );
        member.nickname( d.nickname() );
        member.email( d.email() );
        member.role( d.role() );

        return member.build();
    }

    @Override
    public List<MemberDTO> toDTOList(List<Member> entitiyList) {
        if ( entitiyList == null ) {
            return null;
        }

        List<MemberDTO> list = new ArrayList<MemberDTO>( entitiyList.size() );
        for ( Member member : entitiyList ) {
            list.add( toDto( member ) );
        }

        return list;
    }

    @Override
    public List<Member> toEntityList(List<MemberDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Member> list = new ArrayList<Member>( dtoList.size() );
        for ( MemberDTO memberDTO : dtoList ) {
            list.add( toEntity( memberDTO ) );
        }

        return list;
    }

    @Override
    public Set<MemberDTO> toDTOSet(Set<Member> entitiyList) {
        if ( entitiyList == null ) {
            return null;
        }

        Set<MemberDTO> set = new LinkedHashSet<MemberDTO>( Math.max( (int) ( entitiyList.size() / .75f ) + 1, 16 ) );
        for ( Member member : entitiyList ) {
            set.add( toDto( member ) );
        }

        return set;
    }

    @Override
    public Set<Member> toEntitySet(Set<MemberDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        Set<Member> set = new LinkedHashSet<Member>( Math.max( (int) ( dtoList.size() / .75f ) + 1, 16 ) );
        for ( MemberDTO memberDTO : dtoList ) {
            set.add( toEntity( memberDTO ) );
        }

        return set;
    }

    @Override
    public void updateFromDto(MemberDTO dto, Member e) {
        if ( dto == null ) {
            return;
        }
    }
}
