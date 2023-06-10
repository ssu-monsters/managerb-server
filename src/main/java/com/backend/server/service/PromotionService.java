package com.backend.server.service;

import com.backend.server.domain.Member;
import com.backend.server.domain.Promotion;
import com.backend.server.repository.PromotionRepository;
import com.backend.server.request.PromotionResponse;
import com.backend.server.request.SignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;



    /* public Promotion getPromotionByOrganizationId(int organizationId) {
         return promotionRepository.findByOrganizationId(organizationId);
     }*/
    public List<PromotionResponse> getAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotions.stream()
                .map(PromotionResponse::new)
                .collect(Collectors.toList());
    }
    public PromotionResponse getPromotion(int organizationid) throws Exception{
        Promotion promotion = promotionRepository.findByOrganizationId(organizationid)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new PromotionResponse(promotion);
    }
}