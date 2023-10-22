package com.kjs.roma.controller;

import com.kjs.roma.dto.member.MemberDTO;
import com.kjs.roma.environment.response.JsonResponse;
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

    @PostMapping("/register")
    public JsonResponse register(@RequestBody MemberDTO memberDTO) throws ServiceException{
        return memberService.register(memberDTO);
    }
}
