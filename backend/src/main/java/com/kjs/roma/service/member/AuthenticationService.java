package com.kjs.roma.service.member;

import com.kjs.roma.dto.member.MemberReqDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.environment.response.ResponseCode;
import com.kjs.roma.model.member.Member;
import com.kjs.roma.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

   private final MemberRepository memberRepository;

    public JsonResponse authenticate(MemberReqDTO memberReqDTO){
        Member member = memberRepository.findByEmail(memberReqDTO.email())
                .orElseThrow(() -> new ServiceException(ResponseCode.LOGIN_NOT_FOUND.code()));

        return JsonResponse.create("");
    }
}
