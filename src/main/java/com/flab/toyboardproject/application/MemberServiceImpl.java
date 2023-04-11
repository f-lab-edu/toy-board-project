package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.MemberVo;
import com.flab.toyboardproject.dto.request.MemberSaveRequest;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import com.flab.toyboardproject.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {

    private static final String LOGIN_TOKEN = "LOGIN_TOKEN";

    private final MemberMapper memberMapper;
    private final HttpSession session;

    public MemberServiceImpl(MemberMapper memberMapper, HttpSession session) {
        this.memberMapper = memberMapper;
        this.session = session;
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

    @Override
    public String getCurrentUser() {
        String loginId;
        try {
            loginId = ((MemberVo) session.getAttribute(LOGIN_TOKEN)).getLoginId();
        } catch (RuntimeException e) {
            loginId = "";
        }
        return loginId;
    }

    @Override
    public void aopLogin(String loginId, String password, HttpSession session) {
        MemberVo memberVo = memberMapper.simpleLogin(loginId, password);
        if (Objects.isNull(memberVo)) {
            throw new IllegalArgumentException("회원을 찾을 수 없습니다.");
        }

        session.setAttribute(LOGIN_TOKEN, memberVo);
    }

    @Override
    public MemberVo getAopLoginMemberInfo(HttpSession session) {
        return (MemberVo) session.getAttribute(LOGIN_TOKEN);
    }


}
