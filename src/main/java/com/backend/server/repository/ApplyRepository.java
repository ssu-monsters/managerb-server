package com.backend.server.repository;

import com.backend.server.domain.Apply;
import com.backend.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface ApplyRepository extends JpaRepository<Apply,Long> {
    Optional<Apply> findByAccount(String account);
    Optional<Apply> findByOrganizationsId(String organizationsId);
    Optional<Apply> findUsersNameByOrganizationsId(String organizationsId);
}
