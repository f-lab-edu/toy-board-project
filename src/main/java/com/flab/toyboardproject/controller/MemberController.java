package com.flab.toyboardproject.controller;


import com.flab.toyboardproject.domain.MemberStatus;
import com.flab.toyboardproject.dto.MemberRequest;
import com.flab.toyboardproject.domain.Member;
import com.flab.toyboardproject.dto.MemberResponse;
import com.flab.toyboardproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/join")
    public void join(@RequestBody MemberRequest memberRequest) {

        Member member = new Member(memberRequest.getLoginId(),memberRequest.getPassword(),
                memberRequest.getUserName(),memberRequest.getEmail(), MemberStatus.ENABLE);

        memberService.createMember(member);
    }

    @GetMapping
    public List<MemberResponse> getMembers(){
        return memberService.getMemberList();
    }


    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable("id") Long id){
        return memberService.getMember(id);
    }

}
