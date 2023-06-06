package com.backend.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "member_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String account;

    private String password;

    private String name;

    @Column(unique = true)
    private String email;
    private String thumbnail;
    private String gender;
    //private String prefer;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    @JsonIgnore
    private List<Authority1> roles = new ArrayList<>();

    public void setRoles(List<Authority1> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }
}
