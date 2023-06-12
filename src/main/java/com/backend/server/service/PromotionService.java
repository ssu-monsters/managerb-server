package com.backend.server.service;

import com.backend.server.domain.Member;
import com.backend.server.domain.Promotion;
import com.backend.server.repository.PromotionRepository;
import com.backend.server.request.PromotionRequest;
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

    public PromotionResponse getPromotion(long organizationid) throws Exception {
        Promotion promotion = promotionRepository.findByOrganizationId(organizationid)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new PromotionResponse(promotion);
    }

    public boolean check(PromotionRequest request) throws Exception {
        try {
            Promotion promotion = Promotion.builder()
                    .id(request.getId())
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .target(request.getTarget())
                    .recruitmentPeriod(request.getRecruitmentPeriod())
                    .activityPeriod(request.getActivityPeriod())
                    .recruitmentCount(request.getRecruitmentCount())
                    .organizationType(request.getOrganizationType())
                    .content(request.getContent())
                    .thumbnailImage(request.getThumbnailImage())
                    .organizationId(request.getOrganizationId())
                    .build();


            promotionRepository.save(promotion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }
}