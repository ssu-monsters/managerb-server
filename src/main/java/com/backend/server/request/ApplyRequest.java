package com.backend.server.request;

import lombok.*;


@Getter
@Setter
public class ApplyRequest {
    private String account;
    private String organizationsId;
    private String state;
    private String contentUrl;

}
