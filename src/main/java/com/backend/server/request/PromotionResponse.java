package com.backend.server.request;

import com.backend.server.domain.Promotion;
import com.backend.server.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromotionResponse {

    private Long id;

    private String title;

    private String description;

    private String target;

    private String recruitmentPeriod;

    private String activityPeriod;

    private int recruitmentCount;

    private String organizationType;

    private String content;

    private String thumbnailImage;

    private int organizationId;
    public PromotionResponse(Promotion promotion) {
        this.id = promotion.getId();
        this.title = promotion.getTitle();
        this.description = promotion.getDescription();
        this.target=promotion.getTarget();
        this.recruitmentPeriod = promotion.getRecruitmentPeriod();
        this.activityPeriod = promotion.getActivityPeriod();
        this.recruitmentCount = promotion.getRecruitmentCount();
        this.organizationType=promotion.getOrganizationType();
        this.content = promotion.getContent();
        this.thumbnailImage = promotion.getThumbnailImage();
        this.organizationId = promotion.getOrganizationId();
    }

}