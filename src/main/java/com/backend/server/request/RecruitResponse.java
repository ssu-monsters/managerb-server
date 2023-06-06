package com.backend.server.request;

import com.backend.server.domain.Organization;
import com.backend.server.domain.Recruit;
import com.backend.server.domain.RecruitType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitResponse {
    private Long id;
    private RecruitType recruitType;

    private String step;

    private String applicationFormUrl;


    private Long promotionId;



    private String interviewUrl;

    private String isPass;
    public RecruitResponse(Recruit recruit) {
        this.id = recruit.getId();
        this.applicationFormUrl = recruit.getApplicationFormUrl();
        this.recruitType = recruit.getRecruitType();
        this.promotionId = recruit.getPromotionId();
        this.interviewUrl = recruit.getInterviewUrl();
        this.isPass=recruit.getIsPass();
        this.step=recruit.getStep();
    }
}
