package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.member.Member;
import com.flab.toyboardproject.domain.member.MemberFind;
import com.flab.toyboardproject.global.auth.userdetails.User;
import com.flab.toyboardproject.global.auth.userdetails.UserDetails;
import com.flab.toyboardproject.global.auth.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberFind memberFind;

    public CustomUserDetailsService(MemberFind memberFind) {
        this.memberFind = memberFind;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId, String credentials) {
        Member member = memberFind.login(loginId, credentials);
        if (member == null) {
            throw new IllegalArgumentException();
        }

        return new User(member.getLoginId(), member.getPassword(), null);
    }
}
