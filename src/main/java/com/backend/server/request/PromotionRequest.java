package com.backend.server.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromotionRequest {

    private long id;

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
    //private String prefer;
}