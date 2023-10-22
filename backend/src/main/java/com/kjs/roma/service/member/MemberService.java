package com.kjs.roma.service.member;

import com.kjs.roma.dto.member.MemberDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.environment.response.ResponseCode;
import com.kjs.roma.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public JsonResponse register(MemberDTO memberDTO){
        boolean check = duplicateEmailCheck(memberDTO.email());
        return JsonResponse.create(ResponseCode.SUCCESS);
    }

    public boolean duplicateEmailCheck(String email){
        return memberRepository.existsByEmail(email);
    }
}
