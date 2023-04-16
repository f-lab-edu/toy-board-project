package com.flab.toyboardproject.infra;

import com.flab.toyboardproject.domain.member.MemberFind;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberFindAdapter implements MemberFind {
    private final MemberMapper memberMapper;

    public MemberFindAdapter(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberInfoResponse> getMemberList() {
        return memberMapper.getMemberList();
    }
}
