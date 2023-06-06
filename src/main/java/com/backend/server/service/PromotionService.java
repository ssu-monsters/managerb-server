package com.backend.server.service;

import com.backend.server.domain.Promotion;
import com.backend.server.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public Promotion getPromotionByOrganizationId(String organizationId) {
        return promotionRepository.findByOrganizationId(organizationId);
    }
}
