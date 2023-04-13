package com.flab.toyboardproject.global.auth.userdetails;

import java.util.List;

public interface UserDetails {
    Object getUsername();

    Object getPassword();

    List<String> getAuthorities();

    boolean checkCredentials(Object credentials);
}
