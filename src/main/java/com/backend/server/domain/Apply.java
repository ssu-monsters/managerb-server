package com.backend.server.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
@Getter
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apply_seq")
    @SequenceGenerator(name = "apply_seq", sequenceName = "apply_seq", allocationSize = 1)
    private Long id;
    private String account;
    private String organizationsId;
    private String state;
    //@Column(length = 50000)
    private String contentUrl; //지원서 url index

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account", referencedColumnName = "account", insertable = false, updatable = false)
    private Member member;


}
