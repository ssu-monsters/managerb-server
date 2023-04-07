package com.backend.server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//테이블명에 자동으로 매핑
public class Member {

    /*1. AUTO : DB에 맞게 자동 선택
2. IDENTITY : DB의 identity 컬럼을 이용
3. SEQUENCE : DB의 시퀀스 컬럼을 이용
4. TABLE : 유일성이 보장된 데이터베이스 테이블을 이용*/
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
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

    public String getHakbon() {
        return hakbon;
    }

    public void setHakbon(String hakbon) {
        this.hakbon = hakbon;
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

    private String password;
    private String name;
    private String hakbon;
    private String major;
    private String age;

    public int getMaster() {
        return master;
    }

    public void setMaster(int master) {
        this.master = master;
    }

    private int master;

}
