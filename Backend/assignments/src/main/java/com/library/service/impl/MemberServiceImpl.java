package com.library.service.impl;

import com.library.entity.Member;
import com.library.repository.MemberRepository;
import com.library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Override
    public Member updateMember(Long id, Member updated) {
        Member member = getMemberById(id);
        member.setName(updated.getName());
        member.setEmail(updated.getEmail());
        member.setPhone(updated.getPhone());
        member.setStatus(updated.getStatus());
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}