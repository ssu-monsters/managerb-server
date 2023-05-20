package com.backend.server.repository;

import com.backend.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface SpRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByAccount(String account);
    @Override
    Member save(Member member);
    @Override // Read
    Optional<Member> findById(Long id);

    @Override // Delete
    void deleteById(Long id);
}
