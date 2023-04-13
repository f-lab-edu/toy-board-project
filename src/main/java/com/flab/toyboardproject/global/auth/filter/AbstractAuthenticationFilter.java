package com.flab.toyboardproject.global.auth.filter;

import com.flab.toyboardproject.global.auth.AuthenticationToken;
import com.flab.toyboardproject.global.auth.context.Authentication;
import com.flab.toyboardproject.global.auth.context.SecurityContextHolder;
import com.flab.toyboardproject.global.auth.handler.AuthenticationFailureHandler;
import com.flab.toyboardproject.global.auth.handler.AuthenticationSuccessHandler;
import com.flab.toyboardproject.global.auth.provider.AuthenticationManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

public abstract class AbstractAuthenticationFilter implements HandlerInterceptor {
    private AuthenticationSuccessHandler successHandler;
    private AuthenticationFailureHandler failureHandler;
    private AuthenticationManager authenticationManager;

    public AbstractAuthenticationFilter(AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, AuthenticationManager authenticationManager) {
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Authentication authentication = attemptAuthentication(request, response);
            successfulAuthentication(request, response, authentication);
            return getContinueChainBeforeSuccessfulAuthentication();
        } catch (Exception e) {
            unsuccessfulAuthentication(request, response, e);
            return getContinueChainBeforeUnsuccessfulAuthentication();
        }
    }

    private Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AuthenticationToken token = convert(request);

        return authenticationManager.authenticate(token);
    }

    private void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authentication);

        successHandler.onAuthenticationSuccess(request, response, authentication);
    }

    private boolean getContinueChainBeforeSuccessfulAuthentication() {
        return true;
    }

    private void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Exception failed) throws IOException {
        failureHandler.onAuthenticationFailure(request, response, failed);
    }

    private boolean getContinueChainBeforeUnsuccessfulAuthentication() {
        return false;
    }

    protected abstract AuthenticationToken convert(HttpServletRequest request) throws IOException;
}
