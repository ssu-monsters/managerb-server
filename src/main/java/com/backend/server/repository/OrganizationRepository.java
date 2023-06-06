package com.backend.server.repository;

import com.backend.server.domain.Member;
import com.backend.server.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByAccount(String og_account);

    @Override
    Organization save(Organization organization);

    @Override
        // Read
    Optional<Organization> findById(Long id);

    @Override
        // Delete
    void deleteById(Long id);
}
