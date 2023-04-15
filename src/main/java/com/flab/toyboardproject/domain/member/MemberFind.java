package com.flab.toyboardproject.domain.member;

import com.flab.toyboardproject.dto.response.MemberInfoResponse;

import java.util.List;

public interface MemberFind {
    List<MemberInfoResponse> getMemberList();
}
