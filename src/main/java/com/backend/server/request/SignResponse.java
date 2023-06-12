package com.backend.server.request;

import com.backend.server.domain.Authority1;
import com.backend.server.domain.Authority2;
import com.backend.server.domain.Member;
import com.backend.server.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

    private long id;

    private String account;


    private String name;

    private String email;

    private String thumbnail;
    private String gender;

    //private String prefer;
    private List<Authority1> roles = new ArrayList<>();
    private List<Authority2> og_roles = new ArrayList<>();
    private String token;

    public SignResponse(Member member) {
        this.id = member.getId();
        this.account = member.getAccount();
        this.name = member.getName();
        this.email = member.getEmail();
        this.roles = member.getRoles();
    }
    public SignResponse(Organization organization) {
        this.id = organization.getId();
        this.account = organization.getAccount();
        this.name = organization.getName();
        this.email = organization.getEmail();
        this.og_roles = organization.getOg_roles();
    }
}
