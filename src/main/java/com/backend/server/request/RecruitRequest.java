package com.backend.server.request;

import com.backend.server.domain.RecruitType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class RecruitRequest {
    private Long id;
    private RecruitType recruitType;

    private String step;

    private String applicationFormUrl;


    private Long promotionId;



    private String interviewUrl;

    private String isPass;
}
