package com.backend.server.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_seq")
    @SequenceGenerator(name = "promotion_seq", sequenceName = "promotion_seq", allocationSize = 1)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "target", nullable = false)
    private String target;

    @Column(name = "recruitment_period", nullable = false)
    private String recruitmentPeriod;

    @Column(name = "activity_period", nullable = false)
    private String activityPeriod;

    @Column(name = "recruitment_count", nullable = false)
    private int recruitmentCount;

    @Column(name = "organization_type", nullable = false)
    private String organizationType;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "thumbnail_image", nullable = false)
    private String thumbnailImage;

    @Column(name = "organization_id", nullable = false)
    private long organizationId;

}