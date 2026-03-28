package com.example.cursos.models.catalogs;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CAT_USER_ROLE")
@Data
public class UserRole {
    @Id
    @Column(name = "nrole_id")
    private Long nroleId;

    @Column(name = "crole_code", nullable = false, length = 50, unique = true)
    private String croleCode;

    @Column(name = "crole_name", nullable = false, length = 100, unique = true)
    private String croleName;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}
