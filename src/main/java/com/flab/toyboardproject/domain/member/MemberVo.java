package com.flab.toyboardproject.domain.member;

import com.flab.toyboardproject.domain.Status;

public class MemberVo {
    private Long id;
    private String loginId;
    private String userName;
    private String email;
    private Status status;

    public MemberVo(Long id, String loginId, String userName, String email, Status status) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }
}
