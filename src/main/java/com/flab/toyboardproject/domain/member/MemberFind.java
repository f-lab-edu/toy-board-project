package com.flab.toyboardproject.domain.member;

import com.flab.toyboardproject.dto.response.MemberInfoResponse;

import java.util.List;

public interface MemberFind {
    List<MemberInfoResponse> getMemberList();
    MemberVo simpleLogin(String loginId, String password);
    Member login(String loginId, String password);
    Member getMemberInfo(String loginId);
}
