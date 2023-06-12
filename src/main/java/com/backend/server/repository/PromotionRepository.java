package com.backend.server.repository;

import com.backend.server.domain.Member;
import com.backend.server.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Optional<Promotion> findByOrganizationId(long organizationId);
    List<Promotion> findAll();
    @Override
    Promotion save(Promotion promotion);
}