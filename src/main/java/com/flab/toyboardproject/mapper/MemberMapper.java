package com.flab.toyboardproject.mapper;

import com.flab.toyboardproject.domain.member.Member;
import com.flab.toyboardproject.dto.response.MemberInfoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberInfoResponse> getMemberList();
    void saveMember(Member member1);
}
