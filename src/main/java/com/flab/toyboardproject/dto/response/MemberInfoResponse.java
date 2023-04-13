package com.flab.toyboardproject.dto.response;

import com.flab.toyboardproject.domain.MemberStatus;

public class MemberInfoResponse {

    private String loginId;
    private String userName;
    private String email;
    private MemberStatus status;

    public MemberInfoResponse(String loginId, String userName, String email, MemberStatus status) {
        this.loginId = loginId;
        this.userName = userName;
        this.email = email;
        this.status = status;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public MemberStatus getStatus() {
        return status;
    }
}