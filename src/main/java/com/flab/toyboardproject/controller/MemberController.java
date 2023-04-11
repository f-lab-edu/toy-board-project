package com.flab.toyboardproject.controller;

import com.flab.toyboardproject.annotation.LoginCheck;
import com.flab.toyboardproject.application.MemberService;
import com.flab.toyboardproject.domain.MemberVo;
import com.flab.toyboardproject.dto.request.LoginRequest;
import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/login/simple")
    public String simpleLogin(@RequestBody LoginRequest loginRequest, HttpSession session) {
        MemberVo memberVo = memberService.simpleLogin(loginRequest.getLoginId(), loginRequest.getPassword());
        session.setAttribute(loginRequest.getLoginId(), memberVo);

        return "simple 로그인 완료";
    }

    @GetMapping("/api/login/simple/{loginId}")
    public MemberInfoResponse getSimpleMemberInfo(@PathVariable String loginId, HttpSession session) {
        MemberVo memberVo = (MemberVo) session.getAttribute(loginId);

        return new MemberInfoResponse(memberVo.getLoginId(), memberVo.getUserName(), memberVo.getEmail(), memberVo.getStatus());
    }

    @PostMapping("/api/login/aop")
    public String aopLogin(@RequestBody LoginRequest loginRequest, HttpSession session) {
        memberService.aopLogin(loginRequest.getLoginId(), loginRequest.getPassword(), session);

        return "AOP 로그인 완료";
    }

    @LoginCheck
    @GetMapping("/api/login/aop")
    public MemberInfoResponse getAopMemberInfo(HttpSession session) {
        MemberVo memberVo = memberService.getAopLoginMemberInfo(session);

        return new MemberInfoResponse(memberVo.getLoginId(), memberVo.getUserName(), memberVo.getEmail(), memberVo.getStatus());
    }

    @GetMapping("/api/members")
    public List<MemberInfoResponse> getMemberList() {
        return memberService.getMemberList();
    }

    @PostMapping("/api/members")
    public void saveMember(@RequestBody MemberSaveRequest memberSaveRequest) {
        memberService.saveMember(memberSaveRequest);
    }
}
