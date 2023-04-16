package com.flab.toyboardproject.aop;

import com.flab.toyboardproject.application.MemberService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class LoginCheckAspect {

    private final MemberService memberService;

    public LoginCheckAspect(MemberService memberService) {
        this.memberService = memberService;
    }

    @Before("@annotation(com.flab.toyboardproject.annotation.LoginCheck)")
    public void loginCheck() {
        String loginId = memberService.getCurrentUser();
        if (!StringUtils.hasText(loginId)) {
            throw new IllegalArgumentException(HttpStatus.UNAUTHORIZED.name());
        }
    }
}
