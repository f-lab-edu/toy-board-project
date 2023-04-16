package com.flab.toyboardproject.repository;

import com.flab.toyboardproject.domain.MemberStatus;
import com.flab.toyboardproject.dto.MemberResponse;
import com.flab.toyboardproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    private MemberMapper memberMapper;


    @Autowired
    public MemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }


    public void createMember(String loginId, String userName,
                             String email, String password, MemberStatus status){
        memberMapper.insertMember(loginId,  userName,  email,  password, status.name());
    }


    public List<MemberResponse> findAll() {
        return memberMapper.getMemberList();
    }


    public MemberResponse findById(Long id) {
        return memberMapper.getMemberById(id);
    }

    public MemberResponse findByLoginId(String loginId) {
        return memberMapper.getMemberByLoginId(loginId);
    }
}
