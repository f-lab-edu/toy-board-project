package com.flab.toyboardproject.mapper;


import com.flab.toyboardproject.dto.MemberResponse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("""
            <script>
                select
                    member.id, member.login_id, member.user_name, member.email, member.password, member.created_at
                from member
                where member.id = #{idx} and status = 'ENABLE'
            </script>
            """)
    MemberResponse getMemberById(@Param("idx") Long idx);


    @Select("""
            <script>
                select
                    member.id, member.login_id, member.user_name, member.email, member.password, member.created_at
                from member
                where status = 'ENABLE'
            </script>
            """)
    List<MemberResponse> getMemberList();


    @Insert("""
            <script>
                insert into member(login_id, user_name, password, email, status, created_at, updated_at)
                values (#{loginId}, #{userName}, #{password}, #{email}, #{status}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
            </script>
           """)
    void insertMember(
            @Param("loginId") String loginId,
            @Param("userName") String userName,
            @Param("email") String email,
            @Param("password") String password,
            @Param("status") String status
    );


//    void updateMember(Member member);


//    void deleteMember(int memberIdx);

}
