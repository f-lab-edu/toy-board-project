package com.flab.toyboardproject.application;

import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;

import java.util.List;

public interface MemberService {
    List<MemberInfoResponse> getMemberList();

    void saveMember(MemberSaveRequest memberSaveRequest);
}
