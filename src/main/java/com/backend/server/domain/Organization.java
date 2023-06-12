package com.backend.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_seq1")
    @SequenceGenerator(name = "organization_seq1", sequenceName = "organization_seq1", allocationSize = 1)
    private long id;

    @Column(unique = true)
    private String account;

    private String password;

    private String name;

    @Column(unique = true)
    private String email;
    private String thumbnail;

    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    @JsonIgnore
    private List<Authority2> og_roles = new ArrayList<>();

    public void setRoles(List<Authority2> og_role) {
        this.og_roles = og_role;
        og_role.forEach(o -> o.setOrganization(this));
    }
}

