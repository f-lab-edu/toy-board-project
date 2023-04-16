package com.flab.toyboardproject.service;

import com.flab.toyboardproject.domain.Member;
import com.flab.toyboardproject.domain.MemberStatus;
import com.flab.toyboardproject.dto.MemberResponse;
import com.flab.toyboardproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Transactional(readOnly = true)
    public List<MemberResponse> getMemberList() {
        return memberRepository.findAll();
    }


    @Transactional(readOnly = true)
    public MemberResponse getMember(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Long login(String loginId, String password) {
        MemberResponse member = memberRepository.findByLoginId(loginId);
        if (member.getPassword().equals(password))
            return member.getId();
        return null;
    }

    @Transactional
    public void createMember(Member member) {
        memberRepository.createMember(
                member.getLoginId(),
                member.getUserName(),
                member.getEmail(),
                member.getPassword(),
                MemberStatus.ENABLE
        );
    }

//    @Transactional
//    public void updateMember(Member member) {
//        memberRepository.updateMember(member);
//    }


//    @Transactional
//    public void deleteMember(int memberIdx) {
//        memberRepository.deleteMember(memberIdx);
//    }

}
