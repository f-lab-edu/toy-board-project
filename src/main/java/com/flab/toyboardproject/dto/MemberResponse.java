package com.flab.toyboardproject.dto;


import java.time.LocalDateTime;


public class MemberResponse {

    private Integer id;

    private String loginId;

    private String userName;

    private String password;

    private String email;

    private LocalDateTime createdAt;


    public MemberResponse(Integer id, String loginId, String userName, String password, String email, LocalDateTime createdAt) {
        this.id = id;
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
