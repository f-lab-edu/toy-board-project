package com.flab.toyboardproject.global.auth.provider;

import com.flab.toyboardproject.global.auth.AuthenticationException;
import com.flab.toyboardproject.global.auth.AuthenticationToken;
import com.flab.toyboardproject.global.auth.context.Authentication;
import com.flab.toyboardproject.global.auth.userdetails.UserDetails;
import com.flab.toyboardproject.global.auth.userdetails.UserDetailsService;

public class UserDetailsAuthenticationProvider implements AuthenticationManager {
    private UserDetailsService userDetailsService;

    public UserDetailsAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(AuthenticationToken authenticationToken) {
        String principal = authenticationToken.getPrincipal();
        String credentials = authenticationToken.getCredentials();
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal, credentials);
        checkAuthentication(userDetails, authenticationToken);

        return new Authentication(userDetails.getUsername(), userDetails.getAuthorities());
    }

    private void checkAuthentication(UserDetails userDetails, AuthenticationToken authenticationToken) {
        if (userDetails == null) {
            throw new AuthenticationException();
        }

        if (!userDetails.checkCredentials(authenticationToken.getCredentials())) {
            throw new AuthenticationException();
        }
    }
}
