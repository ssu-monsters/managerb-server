package com.backend.server.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

    private Long id;

    private String account;

    private String password;


    private String name;

    private String email;

    private String thumbnail;
    private String gender;

    //private String prefer;
}
