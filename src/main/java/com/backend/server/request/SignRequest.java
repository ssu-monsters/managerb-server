package com.backend.server.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

    private long id;

    private String account;

    private String password;


    private String name;

    private String email;

    private String thumbnail;
    private String gender;

    //private String prefer;
}
