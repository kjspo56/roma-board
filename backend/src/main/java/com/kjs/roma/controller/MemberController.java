package com.kjs.roma.controller;

import com.kjs.roma.dto.member.MemberDTO;
import com.kjs.roma.dto.member.MemberReqDTO;
import com.kjs.roma.environment.response.JsonResponse;
import com.kjs.roma.service.member.AuthenticationService;
import com.kjs.roma.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final AuthenticationService authenticationService;

    //회원등록
    @PostMapping("/register")
    public JsonResponse register(@RequestBody MemberDTO memberDTO) throws ServiceException{
        return memberService.register(memberDTO);
    }

    //로그인
    @PostMapping("/authenticate")
    public JsonResponse authenticate(@RequestBody MemberReqDTO memberReqDTO){
        return authenticationService.authenticate(memberReqDTO);
    }

    //로그아웃

    //리프레쉬 토큰체크

    //email 체크

    //사용자 리스트

    //사용자 정보 수정

    //비밀번호 수정




}
