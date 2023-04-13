package com.flab.toyboardproject.global.auth.context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class SecurityContextPersistenceFilter implements HandlerInterceptor {

    public static final String SPRING_SECURITY_CONTEXT_KEY = "SPRING_SECURITY_CONTEXT";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SecurityContext securityContext = loadContext(request);
        SecurityContextHolder.setContext(securityContext);
        return true;
    }

    private SecurityContext loadContext(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SecurityContext securityContext = readSecurityContextFromSession(session);

        if (securityContext == null) {
            return SecurityContextHolder.createEmptyContext();
        }

        return securityContext;
    }

    private SecurityContext readSecurityContextFromSession(HttpSession session) {
        if (session == null) {
            return null;
        }

        Object contextFromSession = session.getAttribute(SPRING_SECURITY_CONTEXT_KEY);
        if (contextFromSession == null) {
            return null;
        }

        if (!(contextFromSession instanceof SecurityContext)) {
            return null;
        }

        return (SecurityContext) contextFromSession;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SecurityContext contextAfterChainExecution = SecurityContextHolder.getContext();
        SecurityContextHolder.getContext();
        saveContext(contextAfterChainExecution, request);
    }

    private void saveContext(SecurityContext securityContext, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);
    }
}
