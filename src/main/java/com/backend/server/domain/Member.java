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
/*
@Entity
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor//테이블명에 자동으로 매핑
public class Member {

    /*1. AUTO : DB에 맞게 자동 선택
2. IDENTITY : DB의 identity 컬럼을 이용
3. SEQUENCE : DB의 시퀀스 컬럼을 이용
4. TABLE : 유일성이 보장된 데이터베이스 테이블을 이용*/
  /*  @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;


    @Column(unique = true)
    private String account;
    private String password;
    @Column(unique = true)
    private String email;
    private String name;
    private String thumbnail;
    private String s_ID;
    private String type;
    private String gender;
    private String kind;
    private String prefer;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Authority1> roles = new ArrayList<>();

    public void setRoles(List<Authority1> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }
   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gets_ID() {
        return s_ID;
    }

    public void sets_ID(String hakbon) {
        this.s_ID = hakbon;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getkind() {
        return kind;
    }

    public void setkind(String kind) {
        this.kind = kind;
    }*/
/*
}
*/