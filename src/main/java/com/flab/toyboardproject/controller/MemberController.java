package com.flab.toyboardproject.controller;

import com.flab.toyboardproject.application.MemberService;
import com.flab.toyboardproject.domain.Member;
import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/api/members")
    public List<Member> getMemberList() {
        return memberService.getMemberList();
    }

    @PostMapping("/api/members")
    public void saveMember(@RequestBody MemberSaveRequest memberSaveRequest) {
        memberService.saveMember(memberSaveRequest);
    }


}
