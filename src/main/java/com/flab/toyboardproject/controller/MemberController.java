package com.flab.toyboardproject.controller;


import com.flab.toyboardproject.domain.MemberStatus;
import com.flab.toyboardproject.dto.MemberRequest;
import com.flab.toyboardproject.domain.Member;
import com.flab.toyboardproject.dto.MemberResponse;
import com.flab.toyboardproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
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

    @PostMapping("/login")
    public void login(String loginId, String password, HttpSession session) {
        Long id = memberService.login(loginId, password);
        if (id == null) {
            throw new NullPointerException("존재하지 않는 유저입니다.");
        }

        session.setAttribute("USER_ID", id);
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
