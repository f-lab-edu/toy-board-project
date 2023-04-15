package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.member.MemberCreate;
import com.flab.toyboardproject.domain.member.MemberFind;
import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberCreate memberCreate;
    private final MemberFind memberFind;

    public MemberServiceImpl(MemberCreate memberCreate, MemberFind memberFind) {
        this.memberCreate = memberCreate;
        this.memberFind = memberFind;
    }

    @Override
    public List<MemberInfoResponse> getMemberList() {
        return memberFind.getMemberList();
    }

    @Override
    public void saveMember(MemberSaveRequest memberSaveRequest) {
        memberCreate.save(memberSaveRequest.toEntity());
    }
}
