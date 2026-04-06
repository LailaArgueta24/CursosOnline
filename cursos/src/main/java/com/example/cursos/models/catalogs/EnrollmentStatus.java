package com.example.cursos.models.catalogs;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CAT_ENROLLMENT_STATUS")
@Data
public class EnrollmentStatus {
    @Id
    @Column(name = "nenrollment_status_id")
    private Long nenrollmentStatusId;

    @Column(name = "cstatus_code", nullable = false, length = 50, unique = true)
    private String cstatusCode;

    @Column(name = "cstatus_name", nullable = false, length = 100, unique = true)
    private String cstatusName;

    @Column(name = "bhabilited")
    private Boolean bhabilited = true;

    @Column(name = "dcreated_at", updatable = false)
    private LocalDateTime dcreatedAt;

    @Column(name = "dupdated_at")
    private LocalDateTime dupdatedAt;

    @Column(name = "ddeleted_at")
    private LocalDateTime ddeletedAt;
}

