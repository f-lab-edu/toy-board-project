package com.flab.toyboardproject.dto.response;

public class MemberInfoResponse {

    private String loginId;
    private String userName;
    private String email;
    private String status;

    public MemberInfoResponse(String loginId, String userName, String email, String status) {
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

    public String getStatus() {
        return status;
    }
}
