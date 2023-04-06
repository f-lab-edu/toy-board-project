package com.flab.toyboardproject.service;


import com.flab.toyboardproject.entity.Member;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;


    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    public Member getMember(int memberIdx) {
        return memberMapper.getMemberByIdx(memberIdx);
    }

    public void createMember(Member member) {
        memberMapper.createMember(member);
    }

    public void updateMember(Member member) {
       memberMapper.updateMember(member);
    }

    public void deleteMember(int memberIdx) {
        memberMapper.deleteMember(memberIdx);
    }

}
