package com.mika.authorizationserver.model.entity;

import com.mika.authorizationserver.model.entity.mapped.Auditor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class Security extends Auditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    @OneToOne
    private User user;

}