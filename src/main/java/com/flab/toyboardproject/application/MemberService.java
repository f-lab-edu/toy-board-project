package com.flab.toyboardproject.application;

import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberInfoResponse> getMemberList() {
        return memberMapper.getMemberList();
    }

    @Transactional
    public void saveMember(MemberSaveRequest memberSaveRequest) {
        memberMapper.saveMember(memberSaveRequest.toEntity());
    }
}
