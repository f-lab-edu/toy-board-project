package com.flab.toyboardproject.global.auth.provider;

import com.flab.toyboardproject.global.auth.AuthenticationToken;
import com.flab.toyboardproject.global.auth.context.Authentication;

public interface AuthenticationManager {
    Authentication authenticate(AuthenticationToken authenticationToken);
}
