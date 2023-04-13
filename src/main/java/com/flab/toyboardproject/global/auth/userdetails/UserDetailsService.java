package com.flab.toyboardproject.global.auth.userdetails;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String principal, String credentials);
}
