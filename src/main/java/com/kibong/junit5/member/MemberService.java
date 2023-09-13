package com.kibong.junit5.member;

import com.kibong.junit5.domain.Study;
import com.kibong.junit5.domain.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}