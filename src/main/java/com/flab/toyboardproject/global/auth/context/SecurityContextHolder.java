package com.flab.toyboardproject.global.auth.context;

public class SecurityContextHolder {
    public static final String SPRING_SECURITY_CONTEXT_KEY = "SECURITY_CONTEXT";

    private static final ThreadLocal<SecurityContext> contextHolder;

    static {
        contextHolder = new ThreadLocal<>();
    }

    public static void clearContext() {
        contextHolder.remove();
    }

    public static SecurityContext getContext() {
        SecurityContext securityContext = contextHolder.get();

        if (securityContext == null) {
            securityContext = createEmptyContext();
            contextHolder.set(securityContext);
        }

        return securityContext;
    }

    public static void setContext(SecurityContext context) {
        if (context != null) {
            contextHolder.set(context);
        }
    }

    public static SecurityContext createEmptyContext() {
        return new SecurityContext();
    }
}
