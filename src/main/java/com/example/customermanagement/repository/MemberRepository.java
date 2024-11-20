package com.example.customermanagement.repository;

import java.util.List;
import java.util.Optional;

import com.example.customermanagement.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name); // null처리 방법
    List<Member> findAll();
}
