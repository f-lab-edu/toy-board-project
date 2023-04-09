package com.flab.toyboardproject.domain;

public enum MemberStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String status;

    MemberStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
