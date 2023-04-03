package com.flab.toyboardproject.dto.request;

import com.flab.toyboardproject.domain.Member;

public class MemberSaveRequest {
    private String loginId;
    private String userName;
    private String password;
    private String email;
    private String status;

    public MemberSaveRequest(String loginId, String userName, String password, String email, String status) {
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public Member toEntity() {
        return new Member(getLoginId(), getUserName(), getPassword(), getEmail(), getStatus());
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

    public String getStatus() {
        return status;
    }
}
