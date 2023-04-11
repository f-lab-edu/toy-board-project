package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.MemberVo;
import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberInfoResponse> getMemberList() {
        return memberMapper.getMemberList();
    }

    @Override
    public void saveMember(MemberSaveRequest memberSaveRequest) {
        memberMapper.saveMember(memberSaveRequest.toEntity());
    }

    @Override
    public MemberVo simpleLogin(String loginId, String password) {
        return memberMapper.simpleLogin(loginId, password);
    }
}
