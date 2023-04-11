package com.flab.toyboardproject.domain;

public class MemberVo {
    private Long id;
    private String loginId;
    private String userName;
    private String email;
    private MemberStatus status;

    public MemberVo(Long id, String loginId, String userName, String email, MemberStatus status) {
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

    public MemberStatus getStatus() {
        return status;
    }
}
