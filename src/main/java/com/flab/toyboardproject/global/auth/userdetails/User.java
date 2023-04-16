package com.flab.toyboardproject.global.auth.userdetails;

import java.util.List;

public class User implements UserDetails {
    private String username;
    private String password;
    private List<String> authorities;

    public User() {}

    public User(String username, String password, List<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Object getUsername() {
        return this.username;
    }

    @Override
    public Object getPassword() {
        return this.password;
    }

    @Override
    public List<String> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean checkCredentials(Object credentials) {
        return password.equals(credentials.toString());
    }
}
