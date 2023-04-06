package com.flab.toyboardproject.service;

import com.flab.toyboardproject.entity.Member;

import java.util.List;

public interface MemberService {

    public void createMember(Member member);

    public List<Member> getMemberList();

    public Member getMember(int memberIdx);

    public void updateMember(Member member);

    public void deleteMember(int memberIdx);

}
