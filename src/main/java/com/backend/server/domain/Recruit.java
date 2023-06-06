package com.backend.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recruit_seq")
    @SequenceGenerator(name = "recruit_seq", sequenceName = "recruit_seq", allocationSize = 1)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "organization_account")
    @Column(name = "organization_account")
    private String organization_account;

    @Enumerated(EnumType.STRING)
    private RecruitType recruitType;

    @Column(name = "step")
    private String step;

    @Column(name = "application_form_url")
    private String applicationFormUrl;

    @Column(name = "promotion_id")
    private Long promotionId;


    @Column(name = "interview_url")
    private String interviewUrl;

    @Column(name = "is_pass")
    private String isPass;
    // 추가적인 필드들...
   // private
    // 생성자, 게터/세터, 기타 메서드들...
}

