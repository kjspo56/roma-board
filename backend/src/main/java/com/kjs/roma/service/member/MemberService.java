package com.kjs.roma.service.member;

import com.kjs.roma.dto.member.MemberDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.environment.response.ResponseCode;
import com.kjs.roma.mapper.member.MemberMapper;
import com.kjs.roma.model.member.Member;
import com.kjs.roma.repository.member.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public JsonResponse register(MemberDTO memberDTO){
        boolean check = duplicateEmailCheck(memberDTO.email());
        if(check){
            return JsonResponse.create(ResponseCode.USE_EMAIL);
        } else {
            Member member = Member.builder()
                    .username(memberDTO.username())
                    .nickname(memberDTO.nickname())
                    .password(memberDTO.password())
                    .email(memberDTO.email())
                    .role(memberDTO.role())
                    .build();
            memberRepository.save(member);
            return JsonResponse.create(memberMapper.toDto(member));
        }
    }

    public boolean duplicateEmailCheck(String email){
        return memberRepository.existsByEmail(email);
    }
}
