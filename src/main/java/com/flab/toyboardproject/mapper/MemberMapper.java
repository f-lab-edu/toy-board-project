package com.flab.toyboardproject.mapper;


import com.flab.toyboardproject.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {


    @Select("SELECT * FROM member WHERE memberIdx = #{memberIdx}")
    Member getMemberByIdx(@Param("memberIdx") int memberIdx);

    @Select("SELECT * FROM member")
    List<Member> getMemberList();

    @Insert("insert into member values(#{loginId}, #{userName}, #{password}, #{email}, #{status}, #{})" )
    void createMember(Member member);

    void updateMember(Member member);

    void deleteMember(int memberIdx);

}
