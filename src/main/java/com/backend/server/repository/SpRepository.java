package com.backend.server.repository;

import com.backend.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpRepository extends JpaRepository<Member,Long> {
    @Override
    Member save(Member member);
    @Override // Read
    Optional<Member> findById(Long id);

    @Override // Delete
    void deleteById(Long id);
}
