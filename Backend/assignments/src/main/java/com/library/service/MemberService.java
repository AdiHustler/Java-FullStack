package com.library.service;

import com.library.entity.Member;
import java.util.List;

public interface MemberService {

    Member addMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Long id);

    Member updateMember(Long id, Member updated);

    void deleteMember(Long id);
}