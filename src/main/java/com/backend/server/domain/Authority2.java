package com.backend.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JoinColumn(name = "organization_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Organization organization;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}

