package com.flab.toyboardproject.controller;


import com.flab.toyboardproject.dto.RequestMember;
import com.flab.toyboardproject.entity.Member;
import com.flab.toyboardproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;


    @PostMapping("/join")
    public void join(@RequestBody RequestMember requestMember) {

        Member member = new Member();
        member.setLoginId(requestMember.getLoginId());
        member.setPassword(requestMember.getPassword());
        member.setUserName(requestMember.getUserName());
        member.setEmail(requestMember.getEmail());
        member.setStatus("active");

        memberService.createMember(member);

    }

}
