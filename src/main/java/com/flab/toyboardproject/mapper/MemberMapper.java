package com.flab.toyboardproject.mapper;

import com.flab.toyboardproject.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> getMemberList();
    void saveMember(Member member1);
}
