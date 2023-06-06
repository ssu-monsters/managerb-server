package com.backend.server.repository;

import com.backend.server.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findByOrganizationId(String organizationId);
}
