package com.flab.toyboardproject.dto.request;

import com.flab.toyboardproject.domain.Member;
import com.flab.toyboardproject.domain.MemberStatus;

public class MemberSaveRequest {
    private String loginId;
    private String userName;
    private String password;
    private String email;

    public MemberSaveRequest(String loginId, String userName, String password, String email) {
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Member toEntity() {
        return new Member(getLoginId(), getUserName(), getPassword(), getEmail(), MemberStatus.ACTIVE);
    }

    public String getLoginId() {
        return loginId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
