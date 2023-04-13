package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.Member;
import com.flab.toyboardproject.global.auth.userdetails.User;
import com.flab.toyboardproject.global.auth.userdetails.UserDetails;
import com.flab.toyboardproject.global.auth.userdetails.UserDetailsService;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberMapper memberMapper;

    public CustomUserDetailsService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId, String credentials) {
        Member member = memberMapper.login(loginId, credentials);
        if (member == null) {
            throw new IllegalArgumentException();
        }

        return new User(member.getLoginId(), member.getPassword(), null);
    }
}
