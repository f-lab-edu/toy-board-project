package com.flab.toyboardproject.global.auth;

public enum AuthorizationType {
    BASIC;

    public String toLowerCase() {
        return this.name().toLowerCase();
    }
}
