package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.member.MemberVo;
import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface MemberService {
    List<MemberInfoResponse> getMemberList();

    void saveMember(MemberSaveRequest memberSaveRequest);

    MemberVo simpleLogin(String loginId, String password);

    String getCurrentUser();

    void aopLogin(String loginId, String password, HttpSession session);

    MemberVo getAopLoginMemberInfo(HttpSession session);

    MemberInfoResponse basicLogin(String loginId, String password);
}
