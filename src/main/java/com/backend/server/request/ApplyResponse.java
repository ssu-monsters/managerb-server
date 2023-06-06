package com.backend.server.request;

import com.backend.server.domain.Member;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import com.backend.server.domain.Apply;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@Getter
public class ApplyResponse {
    private Long id;
    private String account;
    private String organizationsId;
    private String state;
    private String contentUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public ApplyResponse(Apply apply) {
       // this.id = apply.getId();
        this.account = apply.getAccount();
        this.organizationsId = apply.getOrganizationsId();
        this.state = apply.getState();
        this.contentUrl = apply.getContentUrl();
    }
}