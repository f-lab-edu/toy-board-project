package com.flab.toyboardproject.dto;


public class MemberRequest {

    private String loginId;

    private String userName;

    private String password;

    private String email;

    public MemberRequest(String loginId, String userName, String password, String email) {
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }


    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
