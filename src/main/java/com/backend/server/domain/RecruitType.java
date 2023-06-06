package com.backend.server.domain;

import javax.persistence.AssociationOverride;

public enum RecruitType {
    PROMOTION_ONLY, // 홍보만
    APPLICATION_ONLY, // 서류만
    INTERVIEW // 면접까지
    ;
    public static AssociationOverride WRITE_PROMOTION_POST;
}
