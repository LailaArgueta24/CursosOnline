package com.example.cursos.models;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TBL_CERTIFICATES")
@Data
public class Certificates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ncertificate_id", nullable = false)
    private Long ncertificateId;

    @ManyToOne
    @JoinColumn(name = "nenrollment_id", nullable = false)
    private Enrollment nenrollmentId;

    @Column(name = "cvalidation_code", length = 64, nullable = false)
    private String cvalidationCode;

    @Column(name = "dissued_at")
    private LocalDateTime dissuedAt;

    @PrePersist
    public void prePersist() {
        this.dissuedAt = LocalDateTime.now();
    }
}
