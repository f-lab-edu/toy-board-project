package com.flab.toyboardproject.global.auth.filter;

import com.flab.toyboardproject.global.auth.AuthenticationToken;
import com.flab.toyboardproject.global.auth.AuthorizationExtractor;
import com.flab.toyboardproject.global.auth.AuthorizationType;
import com.flab.toyboardproject.global.auth.handler.AuthenticationFailureHandler;
import com.flab.toyboardproject.global.auth.handler.AuthenticationSuccessHandler;
import com.flab.toyboardproject.global.auth.provider.AuthenticationManager;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;

public class BasicAuthenticationFilter extends AbstractAuthenticationFilter {
    public BasicAuthenticationFilter(AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, AuthenticationManager authenticationManager) {
        super(successHandler, failureHandler, authenticationManager);
    }

    @Override
    protected AuthenticationToken convert(HttpServletRequest request) throws IOException {
        String authCredentials = AuthorizationExtractor.extract(request, AuthorizationType.BASIC);
        String authHeader = new String(Base64.decodeBase64(authCredentials));

        String[] splits = authHeader.split(":");
        String principal = splits[0];
        String credentials = splits[1];

        return new AuthenticationToken(principal, credentials);
    }
}
