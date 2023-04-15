package com.flab.toyboardproject.infra;

import com.flab.toyboardproject.domain.member.Member;
import com.flab.toyboardproject.domain.member.MemberCreate;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberCreateAdapter implements MemberCreate {
    private final MemberMapper memberMapper;

    public MemberCreateAdapter(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void save(Member member) {
        memberMapper.saveMember(member);
    }
}
